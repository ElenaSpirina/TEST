package api;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static data.AuthData.validAuth;
import static data.DataTest.defaultBooking;
import static data.DataTest.updatedBooking;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Booking API")
@Feature("Independent booking tests")
public class BookingTest extends BaseTest {

    private String getToken() {
        return given()
                .contentType("application/json")
                .body(validAuth())
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }

    @Test
    @Story("Create booking")
    @Severity(SeverityLevel.BLOCKER)
    void createBookingTest() {
        given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body(defaultBooking())
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo(defaultBooking().getFirstname()))
                .body("booking.lastname", equalTo(defaultBooking().getLastname()));
    }

    @Test
    @Story("Get booking")
    @Severity(SeverityLevel.CRITICAL)
    void getBookingTest() {

        int id = given()
                .contentType("application/json")
                .body(defaultBooking())
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");

        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/booking/" + id)
                .then()
                .statusCode(200)
                .body("firstname", equalTo(defaultBooking().getFirstname()))
                .body("lastname", equalTo(defaultBooking().getLastname()));
    }

    @Test
    @Story("Update booking")
    @Severity(SeverityLevel.CRITICAL)
    void updateBookingTest() {

        int id = given()
                .contentType("application/json")
                .body(defaultBooking())
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");

        given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .cookie("token", getToken())
                .body(updatedBooking())
                .when()
                .put("/booking/" + id)
                .then()
                .statusCode(200)
                .body("firstname", equalTo(updatedBooking().getFirstname()))
                .body("lastname", equalTo(updatedBooking().getLastname()));
    }

    @Test
    @Story("Delete booking")
    @Severity(SeverityLevel.BLOCKER)
    void deleteBookingTest() {

        int id = given()
                .contentType("application/json")
                .body(defaultBooking())
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");

        String token = getToken();

        given()
                .filter(new AllureRestAssured())
                .cookie("token", token)
                .when()
                .delete("/booking/" + id)
                .then()
                .statusCode(201);

        // Проверяем, что удалено
        given()
                .when()
                .get("/booking/" + id)
                .then()
                .statusCode(404);
    }
}