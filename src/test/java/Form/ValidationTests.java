package Form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ValidationTests {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 30000;
        Configuration.pageLoadStrategy = "eager";
    }

        @BeforeEach
    void openForm() {
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    // Тест 1: пустое имя
    @Test
    void testFirstNameEmptyValidation() {
        $("#firstName").setValue("");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@gmail.com");
        $("#userNumber").setValue("8995558811");

        $("#submit").scrollTo().click();

        // Проверка встроенной HTML5 валидации
        String message = executeJavaScript(
                "return document.getElementById('firstName').validationMessage;"
        );
        System.out.println("First Name validation message: " + message);
    }

    // Тест 2: пустая фамилия
    @Test
    void testLastNameEmptyValidation() {
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("");
        $("#userEmail").setValue("test@gmail.com");
        $("#userNumber").setValue("8995558811");

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('lastName').validationMessage;"
        );
        System.out.println("Last Name validation message: " + message);
    }

    // Тест 3: пустой Email
    @Test
    void testEmailInvalidValidation() {
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("");
        $("#userNumber").setValue("8995558811");

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('userEmail').validationMessage;"
        );
        System.out.println("Email validation message: " + message);
    }

    // Тест 4: пустой мобильный
    @Test
    void testMobileInvalidValidation() {
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@gmail.com");
        $("#userNumber").setValue("");

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('userNumber').validationMessage;"
        );
        System.out.println("Mobile validation message: " + message);
    }

    // Тест 5: пустой Gender
    @Test
    void testGenderEmptyValidation() {
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@gmail.com");
        $("#userNumber").setValue("8995558811");

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }
}