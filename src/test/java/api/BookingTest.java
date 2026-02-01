package api;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Booking API")
@Feature("Full booking workflow")
public class BookingTest extends BaseTest {

    private static int bookingId; // статическое поле для одного booking на всю цепочку
    private static String token;

    @Test
    @Order(1)
    @Story("Create booking")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Создание бронирования")
    void createBooking() {
        bookingId = given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body("""
                        {
                          "firstname": "Elena",
                          "lastname": "Test",
                          "totalprice": 100,
                          "depositpaid": true,
                          "bookingdates": {
                            "checkin": "2026-01-01",
                            "checkout": "2026-01-10"
                          },
                          "additionalneeds": "Breakfast"
                        }
                        """)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .extract()
                .path("bookingid");

        // Получаем токен для Update/Delete
        token = given()
                .contentType("application/json")
                .body("""
                        {
                          "username": "admin",
                          "password": "password123"
                        }
                        """)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    @Test
    @Order(2)
    @Story("Get booking")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Получение бронирования по ID")
    void getBooking() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Elena"))
                .body("lastname", equalTo("QA"));
    }

    @Test
    @Order(3)
    @Story("Update booking")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Обновление бронирования")
    void updateBooking() {
        given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body("""
                    {
                      "firstname": "Updated",
                      "lastname": "User",
                      "totalprice": 200,
                      "depositpaid": false,
                      "bookingdates": {
                        "checkin": "2026-03-01",
                        "checkout": "2026-03-10"
                      },
                      "additionalneeds": "Lunch"
                    }
                    """)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Updated"))
                .body("lastname", equalTo("User"));
    }

    @Test
    @Order(4)
    @Story("Delete booking")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление бронирования")
    void deleteBooking() {
        given()
                .filter(new AllureRestAssured())
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);
    }
}
