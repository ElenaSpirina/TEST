package pages;

import com.codeborne.selenide.BaseElementsCollection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class YaHomePage {
    SelenideElement enterSearchQuery = $ ("textarea[name='text']");
    SelenideElement clickSearchButton = $ ("button[type='submit']");
    SelenideElement clickCloseButton = $ ("button[aria-label='Нет, спасибо']");

    @Step("Открыть главную страницу Яндекс")
    public YaHomePage openPage() {
        open("https://ya.ru");
        return this;
    }

    @Step("Ввести текст '{query}' в поиск")
    public YaHomePage enterQuery(String query) {
        enterSearchQuery.shouldBe(Condition.visible, Condition.enabled)
                .setValue(query);
        return this;
    }

    @Step("Нажать кнопку 'Найти'")
    public YaHomePage clickSearch() {
        clickSearchButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    @Step("Закрыть окно 'Сделать Яндекс основным поиском?'")
    public YaHomePage clickCloseButton() {
        clickCloseButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }
}



public class YaLogoColorPage {
    SelenideElement checkLogo = $ ("a.HeaderLogo");
    SelenideElement checkColor = $ ("a.HeaderLogo svg path:first-of-type");

    @Step("Проверить, что логотип Яндекса отображается")
    public YaLogoColorPage checkLogo() {
        checkLogo.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить цвет логотипа")
    public YaLogoColorPage checkColor() {
        checkColor.shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("fill", "#F8604A"));
        return this;
    }

}


public class TestYandex {

    private final YaHomePage yaHomePage = new YaHomePage();
    private final YaLogoColorPage yaLogoColorPage = new YaLogoColorPage();

    @BeforeEach
    @Step("Настройка браузера")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void searchAndCheckLogoColor() {
        yaHomePage
                .openPage()
                .enterQuery("тест")
                .clickSearch()
                .clickCloseButton();

        yaLogoColorPage
                .checkLogo()
                .checkColor();
    }

}