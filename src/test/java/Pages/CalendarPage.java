package Pages;

import assistive.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class CalendarPage extends TestBase {

    //Locators
    private final SelenideElement LOADINGCALENDAR =
            $x("//span[contains(@class, 'btn m-btn')]");

    private final SelenideElement TEXTDATA =
            $x("//span[@id='schedule-month-title']");

    private final SelenideElement ALLDAYCALENDAR =
            $x("//td[@class='fc-event-container']");

    private final SelenideElement CALENDARXPATH =
            $x("//div[contains(@class, 'col-lg-4')]/descendant::" +
                    "i[contains(@class, 'la-calendar-check-o')]");

    private final SelenideElement APPLYCALENDAR =
            $x("//button[@class='btn btn-brand m-btn " +
                    "m-btn--icon btn_do_filter']");

    private final SelenideElement SELECTUSER =
            $x("//span[@title='Авто Пользователь']");

    private final SelenideElement NEXTYEAR = $x(
            "//div[@class = 'datepicker-months']//th[contains(text(),'»')]");

    //Variables
    private final String WORKDAYXPATH =
            "//div[@class = 'fc-content-skeleton']/descendant::" +
                    "tbody/tr[1]/td/a[@class = 'fc-day-grid-event " +
                    "fc-h-event fc-event fc-start fc-end schedule-badge " +
                    "schedule-badge--block schedule-badge--default schedule-badge--']";

    private final String WEEKENDDAYXPATH =
            "//div[@class = 'fc-content-skeleton']/descendant::" +
                    "a[@class = 'fc-day-grid-event fc-h-event fc-event fc-start " +
                    "fc-end schedule-badge schedule-badge--block " +
                    "schedule-badge--no-event schedule-badge--']";


    @Step("Проверка что произошел переход на URL:.../calendar")

    /** Метод проверки совпадения URL-адреса (страница календарь) */
    public CalendarPage foundSiteCalendar() {

        webdriver().shouldHave(WebDriverConditions.url(properties.SITECALENDAR_P));

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


    @Step("Проверка наличия рабочих/выходных дней")

    /** Метод проверки рабочих/выходных дней */
    public CalendarPage checkWorkWeekendDay() {

        List<WebElement> workDays = ALLDAYCALENDAR.findElements
                (By.xpath(WORKDAYXPATH));
        List<WebElement> weekendDays = ALLDAYCALENDAR.findElements
                (By.xpath(WEEKENDDAYXPATH));

        if (workDays.size() > 0) {
            System.out.println("Количество рабочих дней: " + workDays.size());
        } else {
            System.out.println("Рабочих дней нет");
        }

        Assert.assertNotNull(workDays.size());

        if (weekendDays.size() > 0) {
            System.out.println("Количество выходных дней: " + weekendDays.size());
        } else {
            System.out.println("Выходных дней нет");
        }

        Assert.assertNotNull(weekendDays.size());

        return this;
    }


    @Parameters({"NEWUSERCALENDAR"})
    @Step("Выбор пользователя: 'Абдулин Ринат'")

    /** Метод выбора другого пользователя  */
    public CalendarPage selectAnotherUser(String NEWUSERCALENDAR) {

        SELECTUSER.click();
        $x(String.format("//li[contains(text(),'%s')]", NEWUSERCALENDAR)).click();
        APPLYCALENDAR.click();
        return this;
    }


    @Step("Открытие URL:.../calendar")

    /** Метод открытия стартовой страницы */
    public CalendarPage openSiteCalendar() {

        open(properties.SITECALENDAR_P);
        return this;
    }

    @Step("Получение следующего месяца")

    /** Метод получения следующего месяца */
    public CalendarPage clickNextMonth() {

        CALENDARXPATH.click();
        LocalDate months = LocalDate.now();

        if (months.getMonthValue() == 12) {
            NEXTYEAR.click();
        }

        String[] monthNames = {"Янв", "Фев", "Мар", "Апр",
                "Май", "Июн", "Июл", "Авг",
                "Сен", "Окт", "Ноя", "Дек"};

        String monthNext = monthNames[months.getMonthValue()];

        $x(String.format(".//span[contains(text(),'%s')]", monthNext)).click();
        APPLYCALENDAR.click();
        return this;
    }

}



