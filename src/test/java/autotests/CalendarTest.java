package autotests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class CalendarTest extends TestBase{


    @BeforeEach
    void preconditionCalendarTest() {

        authorized.Authorized();

        loginPage.clickMenu()
                .clickMenuCalendar()
                .foundSiteCalendar(loginPage.SITECALENDAR)
                .loadCalendar();
    }

    @Test
    void calendarTest1() {

        loginPage.comparisonData()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    void calendarTest2(){
        loginPage.clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    void calendarTest3(){
        loginPage.selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
                sleep(5000);
    }
}
