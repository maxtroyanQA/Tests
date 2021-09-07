package autotests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ScreenShooter.class})
public class CalendarTests extends TestBase {

    @BeforeMethod
    void preconditionCalendarTest() throws IOException {
        authorized.authorizedCookie();

        loginPage.foundSiteCalendar(loginPage.SITECALENDAR)
                .loadCalendar();
    }

    @Test(description = "Сравнение текущей даты календаря", enabled = false)
    void calendarTest1() {
        loginPage.comparisonDate()
                .checkWorkDay()
                .checkWeekendDay();

    }

    @Test(description = "Выбор месяца: октябрь", enabled = false)
    void calendarTest2() {
        loginPage.clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test(description = "Выбор пользователя: 'Абдулин Ринат'", enabled = false)
    void calendarTest3() {
        loginPage.selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }
}
