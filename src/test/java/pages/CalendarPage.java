package pages;

import assistive.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;


public class CalendarPage extends TestBase {

    //Locators
    private final SelenideElement LOADINGCALENDAR =
            $x("//span[contains(@class, 'm-loader--light')]");

    private final SelenideElement TEXTDATA =
            $x("//span[@id='schedule-month-title']");

    private final SelenideElement CALENDARXPATH =
            $x("//div[contains(@class, 'col-lg-4')]/descendant::" +
                    "i[contains(@class, 'la-calendar-check-o')]");

    private final SelenideElement APPLYCALENDAR =
            $x("//button[contains(@class, 'btn_do_filter')]");

    private final SelenideElement SELECTUSER =
            $x("//span[@title='Авто Пользователь']");

    private final SelenideElement NEXTYEAR =
            $x("//div[@class = 'datepicker-months']//th[contains(text(),'»')]");

    private final SelenideElement NEXTMONTH =
            $x(".//span[contains(text(),'%s')]");

    private final SelenideElement SELECTANOTHERUSER =
            $x("//li[contains(text(),'%s')]");

    @Step("Проверка что произошел переход на URL:.../calendar")

    /** Метод проверки совпадения URL-адреса (страница календарь) */
    public CalendarPage foundSiteCalendar() {

        webdriver().shouldHave(WebDriverConditions.url(properties.SITECALENDAR));

        return this;
    }


    @Step("Сравнение даты календаря и текущей даты")

    /** Метод проверки сегодняшней даты и даты календаря */
    public CalendarPage comparisonDate() {

        // Проверка даты на соответствие
        TEXTDATA.shouldHave(Condition.ownText(LocalDate.now().
                format(DateTimeFormatter.ofPattern("LLLL yyyy"))));

        return this;
    }


    @Step("Проверка, что календарь загружен")

    /** Метод проверки загрузки календаря */
    public CalendarPage loadCalendar() {

        LOADINGCALENDAR.waitUntil(Condition.not(Condition.visible), 60000);

        return this;
    }


    @Parameters({"NEWUSERCALENDAR"})
    @Step("Выбор пользователя: 'Абдулин Ринат'")

    /** Метод выбора другого пользователя  */
    public CalendarPage selectAnotherUser(String NEWUSERCALENDAR) {

        SELECTUSER.click();
        $x(String.format(String.valueOf(SELECTANOTHERUSER), NEWUSERCALENDAR)).click();
        APPLYCALENDAR.click();

        return this;
    }


    @Step("Открытие URL:.../calendar")

    /** Метод открытия стартовой страницы */
    public CalendarPage openSiteCalendar() {

        open(properties.SITECALENDAR);

        return this;
    }

    @Step("Получение следующего месяца")

    /** Метод получения следующего месяца */
    public CalendarPage clickNextMonth() {

        CALENDARXPATH.click();
        LocalDate MONTHS = LocalDate.now();

        if (MONTHS.getMonthValue() == 12) {
            NEXTYEAR.click();
        }

        String[] MONTHNAMES = {"Янв", "Фев", "Мар", "Апр",
                "Май", "Июн", "Июл", "Авг",
                "Сен", "Окт", "Ноя", "Дек"};

        String monthNext = MONTHNAMES[MONTHS.getMonthValue()];
        $x(String.format(String.valueOf(NEXTMONTH), monthNext)).click();
        APPLYCALENDAR.click();

        return this;
    }
}



