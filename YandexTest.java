import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class YandexTest {

    @BeforeEach
    @Step("Настройка браузера")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void searchAndCheck() {
        openPageYa();
        enterSearchQuery("тест");
        clickSearchButton();
        clickCloseButton();
        checkLogoAndColor();
    }

    @Step("Открыть главную страницу Яндекс")
    public void openPageYa() {
        open("https://ya.ru");
    }

    @Step("Ввести текст в поиск")
    public void enterSearchQuery(String query) {
        $("textarea[name='text']").shouldBe(Condition.visible).setValue(query);
    }

    @Step("Нажать кнопку 'Найти'")
    public void clickSearchButton() {
        $("button[type='submit']").shouldBe(Condition.enabled).click();
    }

    @Step("Нажать кнопку закрыть окно 'Сделать Яндекс основным поиском?'")
    public void clickCloseButton() {
        $("button[aria-label='Нет, спасибо']").shouldBe(Condition.enabled).click();
    }

    @Step("Проверить отображение логотипа и его цвет")
    public void checkLogoAndColor() {

        // Проверяем логотип
        $("a.HeaderLogo").shouldBe(Condition.visible);

        // Проверяем цвет
        $("a.HeaderLogo svg path:first-of-type").shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("fill", "#F8604A"));
    }
}