package Form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeTest {

    FormSteps steps = new FormSteps();

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 80000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        steps.openForm();
        steps.fillName("Ivan", "Test");
        steps.fillEmail("test@mail.com");
        steps.selectGender();
        steps.fillMobile("8885558811");
        steps.setBirthDate("1988", "November", ".react-datepicker__day--010");
        steps.setSubject("N");
        steps.selectHobbies();
        steps.uploadPicture("src/test/resources/bft10.jpg");
        steps.fillAddress("City");
        steps.selectStateAndCity("Haryana", "Panipat");
        steps.submit();
        steps.checkResult();
        steps.closeModal();
    }
}