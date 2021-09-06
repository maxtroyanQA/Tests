package autotests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


class LoginPage extends TestBase {

    // Объявление пользовательских данных и других значений
    protected String SITE = "https://tt-develop.quality-lab.ru";
    protected String SITELOGIN =
            "https://tt-develop.quality-lab.ru/login";
    protected String SITEEDIT =
            "https://tt-develop.quality-lab.ru/report/group/edit";
    protected String SITECALENDAR =
            "https://tt-develop.quality-lab.ru/calendar/";
    protected String USERLOGIN = "Авто Пользователь";
    protected String USEREMAIL = "1241242@m.r";
    protected String USERPASSWORD = "12345678";
    protected String FOUNDTEXT = "Invalid credentials.";
    protected String WRONGLOGIN = "TestUser";
    protected String WRONGPASS = "Password";
    protected String WORKDAYXPATH =
            "//*[@class='fc-content-skeleton']/table/tbody/tr[1]/td/" +
                    "a[@class='fc-day-grid-event fc-h-event fc-event " +
                    "fc-start fc-end schedule-badge schedule-badge--block " +
                    "schedule-badge--default schedule-badge--']";
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
            $x(".//span[contains(text(),\"Окт\")]");
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

    @Step("Ввод логина")

        // Метод ввода логина
    LoginPage setLOGIN(String setLoginSend) {

        LOGIN.sendKeys(setLoginSend);
        return this;
    }

    @Step("Ввод пароля")

        // Метод ввода пароля
    LoginPage setPass(String setPassSend) {

        PASSWORD.sendKeys(setPassSend);
        return this;
    }

    @Step("Нажатия кнопки Войти")
        // Метод нажатия кнопки Войти
    LoginPage clickButton() {

        /*  Проверка если кнопка видимая,
            то ок если нет, то выдаст в терминал сообщение
            "Кнопка должна быть видимой" */
        BUTTONLOGIN.shouldBe(visible
                .because("Кнопка должна быть видимой")).click();
        return new LoginPage();
    }

    @Step("Поиск текста 'Invalid credentials.'")
        // Метод проверки совпадения URL-адреса (домашняя странница)
    LoginPage foundSiteEdit(String foundSiteEditSet) {

        webdriver().shouldHave(WebDriverConditions.url(foundSiteEditSet));

        return this;
    }

    @Step("Нажатие по аватару")
        // Метод нажатия на аватар пользователя
    LoginPage clickUserAvatar() {

        /*  Проверка если аватар видимый,
            то ок если нет, то выдаст в терминал сообщение
            "Аватар должен быть видимый" */
        AVATAR.shouldBe(visible
                .because("Аватар должен быть видимый")).click();
        return this;
    }

    @Step("Ввод неправильного логина")
        // Метод ввода неправильного логина
    LoginPage setWrongLogin() {

        LOGIN.sendKeys(WRONGLOGIN);
        return this;
    }

    @Step("Ввод неправильного пароля")
        // Метод ввода неправильного пароля
    LoginPage setWrongPass() {

        PASSWORD.sendKeys(WRONGPASS);
        return this;
    }

    @Step("Нажатие на выпадающее меню")
        // Метод нажатия на выпадающее меню
    LoginPage clickMenu() {

        BUTTONMENU.shouldBe(visible
                .because("Меню должно быть видимым")).click();
        return this;
    }

    @Step("Нажатие в выпадающем меню во вкладке Графики работы->Графики работы")
        // Метод нажатия в выпадающем меню на вкладку календарь
    LoginPage clickMenuCalendar() {

        BIGCALENDAR.click();
        MINICALENDAR.click();
        return new LoginPage();
    }

    @Step("Проверка что произошел переход на URL: https://tt-develop.quality-lab.ru/calendar/")
        // Метод проверки совпадения URL-адреса (страница календарь)
    LoginPage foundSiteCalendar(String foundSiteCalendarSet) {

        webdriver().shouldHave(WebDriverConditions.url(foundSiteCalendarSet));

        return this;
    }

    @Step("Сравнение даты календаря и текущей даты")
        // Метод проверки сегодняшней даты и даты календаря
    LoginPage comparisonDate() {

        // Создание массива с названием месяца на русском
        Calendar calendar = Calendar.getInstance();
        String[] monthNames = {"январь", "февраль", "март", "апрель",
                "май", "июнь", "июль", "август",
                "сентябрь", "октябрь", "ноябрь", "декабрь"
        };

        // Получение из системы года, месяца
        // и сопоставляем с массивом состоящих из русских наименований
        String monthNow = monthNames[calendar.get(Calendar.MONTH)];
        String yearNow = String.valueOf(calendar.get(Calendar.YEAR));

        // Проверка даты на соответствие
        TEXTDATA.shouldHave(Condition.ownText(monthNow), Condition.ownText(yearNow));
        return this;
    }

    @Step("Проверка, что календарь загружен")
        // Метод проверки загрузки календаря
    LoginPage loadCalendar() {

        LOADINGCALENDAR.waitUntil(Condition.not(Condition.visible), 60000);
        return this;
    }

    @Step("Проверка наличия рабочих дней")
        // Метод проверки рабочих дней
    LoginPage checkWorkDay() {

        List<WebElement> workDays = ALLDAYCALENDAR.findElements
                (By.xpath(WORKDAYXPATH));
        for (WebElement workDay : workDays) {

            if (workDays.size() > 0) {
            }
        }
        if (workDays.size() > 0) {
            System.out.println("Количество рабочих дней: " + workDays.size());
        } else {
            System.out.println("Рабочих дней нет");
        }

        return this;
    }

    @Step("Проверка наличия выходных дней")
        // Метод проверки выходных дней
    LoginPage checkWeekendDay() {

        List<WebElement> weekendDays = ALLDAYCALENDAR.findElements
                (By.xpath(WEEKENDDAYXPATH));
        for (WebElement weekendDay : weekendDays) {
            if (weekendDays.size() > 0) {
            }
        }
        if (weekendDays.size() > 0) {
            System.out.println("Количество выходных дней: " + weekendDays.size());
        } else {
            System.out.println("Выходных дней нет");
        }
        return this;

    }

    @Step("Выбор месяца сентябрь")
        // Метод нажатия на месяц "Сентябрь"
    LoginPage clickNextMonth() {

        CALENDARXPATH.click();
        NEXTMONTHXPATH.click();
        APPLYCALENDAR.click();
        return this;
    }

    @Step("Выбор пользователя: 'Абдулин Ринат'")
        // Метод выбора пользователя "Абдулин Ринат"
    LoginPage selectAnotherUser() {

        SELECTUSER.click();
        SELECTNEWUSER.click();
        APPLYCALENDAR.click();
        return new LoginPage();
    }

}
