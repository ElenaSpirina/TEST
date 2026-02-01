package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.filters;

public class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Подключаем Allure к REST Assured
        filters(new AllureRestAssured());

        // Логи полезны при падениях
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
