package autotests;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;


@DisplayName("Тесты с календарём")
@ExtendWith(ScreenShooterExtension.class)
public class CalendarTest extends TestBase {

    @BeforeEach
    void preconditionCalendarTest() throws IOException {
        authorized.authorizedCookie();

        loginPage.foundSiteCalendar(loginPage.SITECALENDAR)
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
