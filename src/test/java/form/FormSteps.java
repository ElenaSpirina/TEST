package form;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class FormSteps {

    @Step("Открыть страницу формы")
    public void openForm() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Step("Заполнить имя и фамилию")
    public void fillName(String firstName, String lastName) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
    }

    @Step("Заполнить email")
    public void fillEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Выбрать пол")
    public void selectGender(String gender) {
        $("[for='gender-radio-1']").shouldBe(Condition.visible);

        switch (gender) {
            case "Male":
                $("[for='gender-radio-1']").click();
                break;
            case "Female":
                $("[for='gender-radio-2']").click();
                break;
            case "Other":
                $("[for='gender-radio-3']").click();
                break;
        }
    }

    @Step("Заполнить номер телефона")
    public void fillMobile(String number) {
        $("#userNumber").setValue(number);
    }

    @Step("Выбрать дату рождения")
    public void setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(day).click();
    }

    @Step("Указать Subject")
    public void setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    @Step("Выбрать хобби")
    public void selectHobbies(String hobbiesLine) {

        String[] hobbies = hobbiesLine.split(", ");

        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports":
                    $("[for='hobbies-checkbox-1']").click();
                    break;
                case "Reading":
                    $("[for='hobbies-checkbox-2']").click();
                    break;
                case "Music":
                    $("[for='hobbies-checkbox-3']").click();
                    break;
            }
        }
    }

    @Step("Загрузить изображение")
    public void uploadPicture(String path) {
        $("#uploadPicture").uploadFile(new File(path));
    }

    @Step("Заполнить адрес")
    public void fillAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Выбрать штат и город")
    public void selectStateAndCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    @Step("Отправить форму")
    public void submit() {
        $("#submit").click();
    }

    @Step("Проверить модальное окно с результатами")
    public void checkResult(String fullName,
                            String email,
                            String gender,
                            String mobile,
                            String birthDate,
                            String subject,
                            String hobbies,
                            String picture,
                            String address,
                            String stateCity) {

        $("#example-modal-sizes-title-lg")
                .shouldHave(Condition.text("Thanks for submitting the form"));

        $(".table-responsive")
                .shouldHave(
                        Condition.text(fullName),
                        Condition.text(email),
                        Condition.text(gender),
                        Condition.text(mobile),
                        Condition.text(birthDate),
                        Condition.text(subject),
                        Condition.text(hobbies),
                        Condition.text(picture),
                        Condition.text(address),
                        Condition.text(stateCity)
                );
    }

    @Step("Закрыть окно")
    public void closeModal() {
        $("#closeLargeModal").click();
    }
}