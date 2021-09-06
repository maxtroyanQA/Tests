package autotests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ScreenShooter.class})
public class CalendarTest extends TestBase {

    @BeforeMethod
    void preconditionCalendarTest() throws IOException {
        authorized.authorizedCookie();

        loginPage.foundSiteCalendar(loginPage.SITECALENDAR)
                .loadCalendar();
    }
    @Test
    void calendarTest1() {
        loginPage.comparisonDate()
                .checkWorkDay()
                .checkWeekendDay();

    }

    @Test
    void calendarTest2() {
        loginPage.clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    void calendarTest3() {
        loginPage.selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }
}
