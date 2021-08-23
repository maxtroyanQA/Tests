package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class  LoginPage extends TestBase {
    //Объявление пользоательских данных и других значений
    protected String site = "https://tt-develop.quality-lab.ru";
    protected String siteLogin = "https://tt-develop.quality-lab.ru/login";
    protected String siteEdit = "https://tt-develop.quality-lab.ru/report/group/edit";
    protected String userLogin = "Авто Пользователь";
    protected String email = "1241242@m.r";
    protected String userPassword = "12345678";
    protected String foundText = "Invalid credentials.";
    //CSS и XPath локаторы
    protected SelenideElement login = $("#username");
    protected SelenideElement password = $("#password");
    protected SelenideElement userName = $("span[class='m-card-user__name m--font-weight-500']");
    protected SelenideElement userEmail = $("span[class='m-card-user__email m--font-weight-300 m-link']");

    //метод ввода логина
    LoginPage setLogin() {
        login.sendKeys(userLogin);
        return this;
    }
    //метод ввода пароля
    LoginPage setPass() {
        password.sendKeys(userPassword);
        return this;
    }
    //метод нажатия кнопки Войти
    LoginPage buttonClick() {
        //проверка если конпка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
        $("#_submit")
                .shouldBe(Condition.visible.because("Кнопка должна быть видимой")).click();
        return this;
    }
    //метод нажания на аватар пользователя
    LoginPage clickUserAvatar() {
        //проверка если конпка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
        $("div[class='m-stack__item m-topbar__nav-wrapper']")
                .shouldBe(visible.because("Кнопка должна быть видимой")).click();
        return this;
    }
}