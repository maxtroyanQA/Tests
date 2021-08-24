package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

class  LoginPage extends TestBase {
    //Объявление пользоательских данных и других значений
    protected String site = "https://tt-develop.quality-lab.ru";
    protected String siteLogin = "https://tt-develop.quality-lab.ru/login";
    protected String siteEdit = "https://tt-develop.quality-lab.ru/report/group/edit";
    protected String userLogin = "Авто Пользователь";
    protected String userEmail = "1241242@m.r";
    protected String userPassword = "12345678";
    protected String foundText = "Invalid credentials.";
    protected String wrongLogin = "TestUser";
    protected String wrongPass = "Password";
    //CSS и XPath локаторы
    protected SelenideElement login = $("#username");
    protected SelenideElement password = $("#password");
    protected SelenideElement name = $("span[class='m-card-user__name m--font-weight-500']");
    protected SelenideElement email = $("span[class='m-card-user__email m--font-weight-300 m-link']");
    protected SelenideElement allPage = $("[class = 'm-login__signin']");

    //метод ввода логина
    LoginPage setLogin(String setLoginSend) {
        login.sendKeys(setLoginSend);
        return this;
    }
    //метод ввода пароля
    LoginPage setPass(String setPassSend) {
        password.sendKeys(setPassSend);
        return this;
    }
    //метод нажатия кнопки Войти
    LoginPage buttonClick() {
        //проверка если кнопка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
        $("#_submit")
                .shouldBe(Condition.visible.because("Кнопка должна быть видимой")).click();
        return this;
    }
    LoginPage foundSiteEdit(String foundSiteEditSet) {
        //проверка если кнопка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
       Assertions.assertEquals(url(),foundSiteEditSet);
        return this;
    }
    //метод нажатия на аватар пользователя
    LoginPage clickUserAvatar() {
        //проверка если кнопка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
        $("div[class='m-stack__item m-topbar__nav-wrapper']")
                .shouldBe(visible.because("Аватар должен быть видимый")).click();
        return this;
    }
    //метод ввода неправильного логина
    LoginPage setWrongLogin() {
        login.sendKeys(wrongLogin);
        return this;
    }
    //метод ввода неправильного пароля
    LoginPage setWrongPass() {
        password.sendKeys(wrongPass);
        return this;
    }
}