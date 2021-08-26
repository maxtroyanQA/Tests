package autotests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Calendar;
import java.util.List;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;


class  LoginPage extends TestBase {
    // Объявление пользовательских данных и других значений
    protected String SITE = "https://tt-develop.quality-lab.ru";
    protected String SITELOGIN =
                     "https://tt-develop.quality-lab.ru/login";
    protected String SITEEDIT =
                     "https://tt-develop.quality-lab.ru/report/group/edit1";
    protected String SITECALENDAR =
                     "https://tt-develop.quality-lab.ru/calendar/";
    protected String USERLOGIN = "Авто Пользователь";
    protected String USEREMAIL = "1241242@m.r";
    protected String USERPASSWORD = "12345678";
    protected String FOUNDTEXT = "Invalid credentials.";
    protected String WRONGLOGIN = "TestUser";
    protected String WRONGPASS = "Password";
    protected String WORKDAYXPATH =
                     "//a[@class='fc-day-grid-event fc-h-event " +
                     "fc-event fc-start fc-end schedule-badge " +
                     "schedule-badge--block schedule-badge--default " +
                     "schedule-badge--']";
    protected String WEEKENDDAYXPATH =
                     "//a[@class='fc-day-grid-event fc-h-event fc-event " +
                     "fc-start fc-end schedule-badge " +
                     "schedule-badge--block schedule-badge--no-event " +
                     "schedule-badge--']";
    // CSS и XPath локаторы
    protected SelenideElement LOGIN = $("#username");
    protected SelenideElement PASSWORD = $("#password");
    protected SelenideElement NAME =
              $("span[class='m-card-user__name m--font-weight-500']");
    protected SelenideElement EMAIL =
              $("span[class='m-card-user__email m--font-weight-300 m-link']");
    protected SelenideElement ALLPAGE = $("[class = 'm-login__signin']");
    protected SelenideElement BUTTONLOGIN = $("#_submit");
    protected SelenideElement BUTTONMENU = $("#m_aside_left_minimize_toggle");
    protected SelenideElement AVATAR =
              $("div[class='m-stack__item m-topbar__nav-wrapper']");
    protected SelenideElement LOADINGCALENDAR =
              $("span[class='btn m-btn btn-primary m-loader " +
                         "m-loader--light m-loader--lg m-loader--left']");
    protected SelenideElement TEXTDATA =
              $x("//span[@id='schedule-month-title']");
    protected SelenideElement ALLDAYCALENDAR =
              $x("//td[@class='fc-event-container']");
    protected SelenideElement NEXTMONTHXPATH =
              $x(".//span[contains(text(),\"Сен\")]");
    protected SelenideElement CALENDARXPATH =
              $x("//div[@class= 'input-group date filter_input_date']" +
                              "/span[@class='input-group-addon']");
    protected SelenideElement APPLYCALENDAR =
              $x("//button[@class='btn btn-brand m-btn " +
                              "m-btn--icon btn_do_filter']");
    protected SelenideElement SELECTUSER =
              $x("//span[@title='Авто Пользователь']");
    protected SelenideElement SELECTNEWUSER =
              $x("//li[contains(text(),'Абдулин Ринат')]");
    protected SelenideElement BIGCALENDAR =
              $x("//*[@id='mCSB_1_container']/ul/li[4]");
    protected SelenideElement MINICALENDAR =
              $x("//div[@class = 'm-menu__submenu'] //a[@href = '/calendar/']");

    // Метод ввода логина
    LoginPage setLOGIN(String setLoginSend) {

        LOGIN.sendKeys(setLoginSend);
        return this;
    }

    // Метод ввода пароля
    LoginPage setPass(String setPassSend) {

        PASSWORD.sendKeys(setPassSend);
        return this;
    }

    // Метод нажатия кнопки Войти
    LoginPage clickButton() {

        /*  Проверка если кнопка видимая,
            то ок если нет, то выдаст в терминал сообщение
            "Кнопка должна быть видимой" */
        BUTTONLOGIN.shouldBe(Condition.visible
            .because("Кнопка должна быть видимой")).click();
        return this;
    }

    // Метод проверки совпадения URL-адреса (домашняя странница)
    LoginPage foundSiteEdit(String foundSiteEditSet) {

       Assertions.assertEquals(url(), foundSiteEditSet);
        return this;
    }

    // Метод нажатия на аватар пользователя
    LoginPage clickUserAvatar() {

        /*  Проверка если аватар видимый,
            то ок если нет, то выдаст в терминал сообщение
            "Аватар должен быть видимый" */
        AVATAR.shouldBe(visible
            .because("Аватар должен быть видимый")).click();
        return this;
    }

    // Метод ввода неправильного логина
    LoginPage setWrongLogin() {

        LOGIN.sendKeys(WRONGLOGIN);
        return this;
    }

    // Метод ввода неправильного пароля
    LoginPage setWrongPass() {

        PASSWORD.sendKeys(WRONGPASS);
        return this;
    }

    // Метод нажатия на выпадающее меню
    LoginPage clickMenu() {

        BUTTONMENU.shouldBe(visible
            .because("Меню должно быть видимым")).click();
        return this;
    }

    // Метод нажатия в выпадающем меню на вкладку календарь
    LoginPage clickMenuCalendar(){

        BIGCALENDAR.click();
        MINICALENDAR.click();
        return this;
    }

    // Метод проверки совпадения URL-адреса (страница календарь)
    LoginPage foundSiteCalendar(String foundSiteCalendarSet) {

        Assertions.assertEquals(url(), foundSiteCalendarSet);
        return this;
    }

    // Метод проверки сегодняшней даты и даты календаря
    LoginPage comparisonData(){

        // Создание массива с названием месяца на русском
        Calendar calendar = Calendar.getInstance();
        String[] monthNames = { "январь", "февраль", "март", "апрель",
                "май", "июнь", "июль", "август",
                "сентябрь", "октябрь", "ноябрь", "декабрь"
        };

        // Получение из системы года, месяца
        // и сопоставляем с массивом состоящих из русских наименований
        String monthNow = monthNames[calendar.get(Calendar.MONTH)];
        String yearNow = String.valueOf(calendar.get(Calendar.YEAR));

        // Проверка даты на соответствие
        TEXTDATA.shouldHave(ownText(monthNow), ownText(yearNow));
        return this;
    }

    // Метод проверки загрузки календаря
    LoginPage loadCalendar(){

        LOADINGCALENDAR.waitUntil(Condition.not(visible),60000);
        return this;
    }

    // Метод проверки рабочих дней
    LoginPage checkWorkDay(){

        List<WebElement> workDays = ALLDAYCALENDAR.findElements
                (By.xpath(WORKDAYXPATH));
        for (WebElement workDay : workDays) {
            if (workDays.size() > 0){
                System.out.println("Work days " + workDays.size());
            } else{
                System.out.println("no work days");
            }
        }
        return this;
    }

    // Метод проверки выходных дней
    LoginPage checkWeekendDay(){

        List<WebElement> weekendDays = ALLDAYCALENDAR.findElements
                (By.xpath(WEEKENDDAYXPATH));
        for (WebElement weekendDay : weekendDays) {
            if (weekendDays.size() > 0){
                System.out.println("Weekend days " + weekendDays.size());
            } else{
                System.out.println("no weekend days");
            }
        }
        return this;
    }

    // Метод нажатия на месяц "Сентябрь"
    LoginPage clickNextMonth(){

        CALENDARXPATH.click();
        NEXTMONTHXPATH.click();
        APPLYCALENDAR.click();
        return this;
    }

    // Метод выбора пользователя "Абдулин Ринат"
    LoginPage selectAnotherUser(){

        SELECTUSER.click();
        SELECTNEWUSER.click();
        APPLYCALENDAR.click();
       return this;
    }


}