package Form;

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
    public void selectGender() {
        $("[for='gender-radio-1']").click();
    }

    @Step("Заполнить номер телефона")
    public void fillMobile(String number) {
        $("#userNumber").setValue(number);
    }

    @Step("Выбрать дату рождения")
    public void setBirthDate(String year, String month, String dayClass) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(dayClass).click();
    }

    @Step("Указать Subject")
    public void setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    @Step("Выбрать хобби")
    public void selectHobbies() {
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
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
    public void checkResult() {
        $("#example-modal-sizes-title-lg")
                .shouldHave(Condition.text("Thanks for submitting the form"));

        $(".table-responsive")
                .shouldHave(
                        Condition.text("Ivan Test"),
                        Condition.text("test@mail.com"),
                        Condition.text("Male"),
                        Condition.text("8885558811"),
                        Condition.text("10 November,1988"),
                        Condition.text("N"),
                        Condition.text("Reading, Music"),
                        Condition.text("bft10.jpg"),
                        Condition.text("City"),
                        Condition.text("Haryana Panipat")
                );
    }
    @Step("Закрыть окно")
    public void closeModal() {
        $("#closeLargeModal").click();
    }
}