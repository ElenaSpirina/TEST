package data;

import com.codeborne.selenide.Configuration;
import form.FormSteps;
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
        String firstName = "Ivan";
        String lastName = "Test";
        String email = "test@mail.com";
        String gender = "Male";
        String mobile = "8885558811";
        String year = "1988";
        String month = "November";
        String day = ".react-datepicker__day--010";
        String subject = "N";
        String hobbies = "Reading, Music";
        String picture = "bft10.jpg";
        String address = "City";
        String state = "Haryana";
        String city = "Panipat";

        steps.openForm();
        steps.fillName(firstName, lastName);
        steps.fillEmail(email);
        steps.selectGender(gender);
        steps.fillMobile(mobile);
        steps.setBirthDate(year, month, day);
        steps.setSubject(subject);
        steps.selectHobbies(hobbies);
        steps.uploadPicture("src/test/resources/" + picture);
        steps.fillAddress(address);
        steps.selectStateAndCity(state, city);
        steps.submit();

        steps.checkResult(
                firstName + " " + lastName,
                email,
                gender,
                mobile,
                "10 " + month + "," + year,
                subject,
                hobbies,
                picture,
                address,
                state + " " + city
        );
    }
}