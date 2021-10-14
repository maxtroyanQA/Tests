package autotests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Тесты с календарём")
@ExtendWith(ScreenshotExtension.class)
public class CalendarTest extends TestBase {

    @BeforeEach
    void preconditionCalendarTest() {
        authorized.Authorized();

        loginPage.clickMenu()
                .clickMenuCalendar()
                .foundSiteCalendar(loginPage.SITECALENDAR)
                .loadCalendar();
    }

    @Test
    @DisplayName("Сравнение даты и проверка рабочих/выходных дней")
    void calendarTest1() {
        loginPage.comparisonDate()
                .checkWorkDay()
                .checkWeekendDay();

    }

    @Test
    @DisplayName("Выбор месяца 'Сентябрь' и проверка рабочих/выходных дней")
    void calendarTest2() {
        loginPage.clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    @DisplayName("Выбор другого пользователя и проверка рабочих/выходных дней")
    void calendarTest3() {
        loginPage.selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }
}