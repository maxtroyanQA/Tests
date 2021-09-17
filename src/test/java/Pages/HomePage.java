package Pages;

import assistive.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HomePage extends TestBase {

    //Locators
    private final SelenideElement NAME =
            $x("//span[contains(@class, 'm-card-user__name')]");

    private final SelenideElement EMAIL =
            $x("//span[contains(@class, 'm-card-user__email')]");

    private final SelenideElement BUTTONMENU = $("#m_aside_left_minimize_toggle");

    private final SelenideElement AVATAR =
            $x("//div[@id='m_header_topbar']");

    private final SelenideElement BIGCALENDAR =
            $x("//a[@class = 'm-menu__link m-menu__toggle']" +
                    "/descendant::span[@class='m-menu__link-text' and" +
                    " contains(text(),'Графики работы')]");

    private final SelenideElement MINICALENDAR =
            $x("//div[@class = 'm-menu__submenu'] //a[@href = '/calendar/']");


    //Variables



    @Step("Проверка URL:.../edit")

    /** Метод проверки совпадения URL-адреса (домашняя странница) */
    public HomePage foundSiteEdit() {

        webdriver().shouldHave(url(properties.SITEEDIT_P));

        return this;
    }


    @Step("Нажатие по аватару")

    /** Метод нажатия на аватар пользователя */
    public HomePage clickUserAvatar() {

        /*  Проверка если аватар видимый,
            то ок если нет, то выдаст в терминал сообщение
            "Аватар должен быть видимый" */
        AVATAR.shouldBe(visible
                .because("Аватар должен быть видимый")).click();

        return this;
    }


    @Step("Нажатие на выпадающее меню")

    /** Метод нажатия на выпадающее меню */
    public HomePage clickMenu() {

        BUTTONMENU.shouldBe(visible
                .because("Меню должно быть видимым")).click();

        return this;
    }


    @Step("Нажатие в выпадающем меню во вкладке Графики работы->Графики работы")

    /** Метод нажатия в выпадающем меню на вкладку календарь */
    public HomePage clickMenuCalendar() {

        BIGCALENDAR.click();
        MINICALENDAR.click();

        return this;
    }


    @Step("Проверка пользователя")

    /** Метод проверки пользователя */
    public HomePage checkLogin() {

        NAME.shouldHave(Condition.text(properties.LOGIN_P));

        return this;
    }


    @Step("Проверка email")

    /** Метод проверки email */
    public HomePage checkEmail() {

        EMAIL.shouldHave(Condition.text(properties.USEREMAIL_P));

        return this;
    }
}
