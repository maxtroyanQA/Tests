package Pages;

import assistive.TestBase;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage extends TestBase {

    //Locators
    private final SelenideElement LOGIN = $x("//input[@name = '_username']");

    private final SelenideElement PASSWORD = $("#password");

    private final SelenideElement BUTTONLOGIN = $("#_submit");

    private final SelenideElement INVALIDCREDENTIALS = $(byText(FOUNDTEXT));

    //Variables

    private final static String FOUNDTEXT = "Invalid credentials.";

    private final static String SITELOGIN =
            "https://tt-develop.quality-lab.ru/login";


    @Step("Ввод логина")

    /** Метод ввода логина */
    public LoginPage setLOGIN(String setLoginSend) {

        LOGIN.sendKeys(setLoginSend);

        return this;
    }


    @Step("Ввод пароля")

    /** Метод ввода пароля */
    public LoginPage setPass(String setPassSend) {

        PASSWORD.sendKeys(setPassSend);

        return this;
    }


    @Step("Нажатия кнопки Войти")

    /**Метод нажатия кнопки Войти*/
    public LoginPage clickButton() {

        /*  Проверка если кнопка видимая,
            то ок если нет, то выдаст в терминал сообщение
            "Кнопка должна быть видимой" */
        BUTTONLOGIN.shouldBe(visible
                .because("Кнопка должна быть видимой")).click();

        return this;
    }


    @Step("Ввод неправильного логина")

    /** Метод ввода неправильного логина */
    public LoginPage setWrongLogin(String WRONGUSER) {

        LOGIN.sendKeys(WRONGUSER);

        return this;
    }


    @Step("Ввод неправильного пароля")

    /** Метод ввода неправильного пароля */
    public LoginPage setWrongPass(String WRONGPASS) {

        PASSWORD.sendKeys(WRONGPASS);

        return this;
    }


    @Step("Надпись 'Invalid credentials.' отсутствует")

    /** Метод проверки отсутствия надписи Invalid credentials. на странице */
    public LoginPage checkNotInvalid() {


        $(byText(FOUNDTEXT)).shouldBe(hidden);

        return this;
    }


    @Step("Проверка URL:.../login")

    /** Метод проверки URL .../login */
    public LoginPage checkSiteLogin() {

        webdriver().shouldHave(WebDriverConditions.url(SITELOGIN));

        return this;
    }


    @Step("Надпись 'Invalid credentials.' присутствует")

    /** Метод проверки наличия надписи Invalid credentials. на странице */
    public LoginPage checkInvalid() {

        INVALIDCREDENTIALS.shouldBe(visible);

        return this;
    }


    @Step("Открытие стартовой страницы ТТ")

    /** Метод открытия стартовой страницы */
    public LoginPage openStartSite() {

        open(properties.startSITE_P);

        return this;
    }
    @Step("Проверка, что в поле 'Имя пользователя' сохранился текст, введенный ранее")

    /** Метод проверки поля 'Имя пользователя', сохранился текст введенный ранее */
    public LoginPage poleLogin(String WRONGUSER) {

        LOGIN.shouldHave(value(WRONGUSER));

        return this;
    }


    @Step("Проверка, что поле 'Пароль' пустое")

    /** Метод проверки поля 'пароль', поле пустое */
    public LoginPage polePass() {

        PASSWORD.shouldHave(value(""));

        return this;
    }
}
