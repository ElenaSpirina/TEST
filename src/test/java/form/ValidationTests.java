package form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import data.DaTest;

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

    private void safeClickSubmit() {
        executeJavaScript("document.querySelector('footer').style.display='none'");
        executeJavaScript("arguments[0].click();", $("#submit").getWrappedElement());
    }

    // Тест 1: пустое имя
    @Test
    void testFirstNameEmptyValidation() {
        $("#firstName").setValue("");
        $("#lastName").setValue(DaTest.lastName);
        $("#userEmail").setValue(DaTest.email);
        $("#userNumber").setValue(DaTest.mobile);

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('firstName').validationMessage;"
        );
        System.out.println("First Name validation message: " + message);
    }

    // Тест 2: пустая фамилия
    @Test
    void testLastNameEmptyValidation() {
        $("#firstName").setValue(DaTest.firstName);
        $("#lastName").setValue("");
        $("#userEmail").setValue(DaTest.email);
        $("#userNumber").setValue(DaTest.mobile);

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('lastName').validationMessage;"
        );
        System.out.println("Last Name validation message: " + message);
    }

    // Тест 3: пустой Email
    @Test
    void testEmailInvalidValidation() {
        $("#firstName").setValue(DaTest.firstName);
        $("#lastName").setValue(DaTest.lastName);
        $("#userEmail").setValue("");
        $("#userNumber").setValue(DaTest.mobile);

        $("#submit").scrollTo().click();

        String message = executeJavaScript(
                "return document.getElementById('userEmail').validationMessage;"
        );
        System.out.println("Email validation message: " + message);
    }

    // Тест 4: пустой мобильный
    @Test
    void testMobileInvalidValidation() {
        $("#firstName").setValue(DaTest.firstName);
        $("#lastName").setValue(DaTest.lastName);
        $("#userEmail").setValue(DaTest.email);
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
        $("#firstName").setValue(DaTest.firstName);
        $("#lastName").setValue(DaTest.lastName);
        $("#userEmail").setValue(DaTest.email);
        $("#userNumber").setValue(DaTest.mobile);

        // Пол не выбираем
        $("#submit").scrollTo().click();

        // Проверяем, что модальное окно не появилось
        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }
}