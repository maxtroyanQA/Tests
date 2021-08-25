package autotests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CalendarTest extends AuthorizedTestBase {
    @BeforeEach
    void preconditionCalendarTest() {
        clickMenu()
                .clickMenuCalendar()
                .foundSiteCalendar(siteCalendar)
                .loadCalendar();
    }

    @Test
    void calendarTest1() {
        dataComparison()
                .checkWorkDay()
                .checkWeekendDay();
    }
    @Test
    void calendarTest2(){
        $x("//div[@class= 'input-group date filter_input_date']/span[@class='input-group-addon']").click();
sleep(10000);
    }
}
