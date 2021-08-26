package autotests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class CalendarTest extends AuthorizedTestBase {

    @BeforeEach
    void preconditionCalendarTest() {
        clickMenu()
                .clickMenuCalendar()
                .foundSiteCalendar(SITECALENDAR)
                .loadCalendar();
    }

    @Test
    void calendarTest1() {
        comparisonData()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    void calendarTest2(){
        clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
    }

    @Test
    void calendarTest3(){
        selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();
                sleep(5000);
    }
}
