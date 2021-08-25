package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

class  LoginPage extends TestBase {
    //Объявление пользоательских данных и других значений
    protected String site = "https://tt-develop.quality-lab.ru";
    protected String siteLogin = "https://tt-develop.quality-lab.ru/login";
    protected String siteEdit = "https://tt-develop.quality-lab.ru/report/group/edit";
    protected String siteCalendar = "https://tt-develop.quality-lab.ru/calendar/";
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
    protected SelenideElement buttonLogin = $("#_submit");
    protected SelenideElement buttonMenu = $("#m_aside_left_minimize_toggle");
    protected SelenideElement avatar = $("div[class='m-stack__item m-topbar__nav-wrapper']");
    protected SelenideElement loadingCalendar = $("span[class='btn m-btn btn-primary m-loader m-loader--light m-loader--lg m-loader--left']");
    protected SelenideElement table =$x("//tbody[@class='fc-body']");
    protected ElementsCollection allDayTable = $$x("//div[@class='fc-day-grid fc-unselectable']" +
            "// a[@class= 'fc-day-grid-event fc-h-event fc-event fc-start " +
            "fc-end schedule-badge schedule-badge--block schedule-badge--default schedule-badge--']");
    protected SelenideElement allDayCalendar = $x("//td[@class='fc-event-container']");
//    protected ElementsCollection workDays = $$x("//div[@class='fc-day-grid fc-unselectable']" +
//            "// a[@class= 'fc-day-grid-event fc-h-event fc-event fc-start " +
//            "fc-end schedule-badge schedule-badge--block schedule-badge--default schedule-badge--']");


    //ElementsCollection WORKDAY = $$x("//div[@class='fc-day-grid fc-unselectable']// a[@class= 'fc-day-grid-event fc-h-event fc-event fc-start fc-end schedule-badge schedule-badge--block schedule-badge--default schedule-badge--']");
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
        buttonLogin.shouldBe(Condition.visible.because("Кнопка должна быть видимой")).click();
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
        avatar.shouldBe(visible.because("Аватар должен быть видимый")).click();
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
    //метод ввода неправильного пароля
    LoginPage clickMenu() {
        buttonMenu.shouldBe(visible.because("Кнопка должна быть видимой")).click();;
        return this;
    }
    LoginPage clickMenuCalendar(){
        $x("//*[@id='mCSB_1_container']/ul/li[4]").click();
        $x("//div[@class = 'm-menu__submenu'] //a[@href = '/calendar/'] ").click();
        return this;
    }
    LoginPage foundSiteCalendar(String foundSiteCalendarSet) {
        //проверка если кнопка видимая, то ок если нет, то выдаст в терминал сообщение "Кнопка должна быть видимой"
        Assertions.assertEquals(url(),foundSiteCalendarSet);
        return this;
    }
    LoginPage dataComparison (){
        //получение из системы года и месяца на русском
        Calendar calendar = Calendar.getInstance();
        String[] monthNames = { "январь", "февраль", "март", "апрель",
                "май", "июнь", "июль", "август",
                "сентябрь", "октябрь", "ноябрь", "декабрь"
        };
        String monthNow = monthNames[calendar.get(Calendar.MONTH)];
        String yearNow = String.valueOf(calendar.get(Calendar.YEAR));
        //проверка, что есть дата соответствует
        SelenideElement textData = $x("//span[@id='schedule-month-title']");
        textData.shouldHave(ownText(monthNow), ownText(yearNow));
        return this;
    }
    LoginPage loadCalendar (){
        loadingCalendar.waitUntil(Condition.not(visible),60000);
        return this;
    }
    LoginPage checkWorkDay (){
        List<WebElement> workDays = allDayCalendar.findElements
                (By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end schedule-badge " +
                        "schedule-badge--block schedule-badge--default schedule-badge--']"));
        for (WebElement workDay : workDays) {
            if (workDays.size()>0){
            }
            else{
                System.out.println("no working days");
            }
        }
        return this;
    }
    LoginPage checkWeekendDay (){
        List<WebElement> weekendDays = allDayCalendar.findElements
                (By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end schedule-badge " +
                        "schedule-badge--block schedule-badge--no-event schedule-badge--']"));
        for (WebElement weekendDay : weekendDays) {
            if (weekendDays.size()>0){
            }
            else{
                System.out.println("no weekend days");
            }
        }
        return this;
    }
    LoginPage choiceNextMonth (){
System.out.println("ok");
return this;
    }
}