package autotests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalendarTest extends AuthorizedTestBase{
    @BeforeEach
    void preconditionCalendarTest(){
        clickMenu()
                .clickMenuCalendar()
                .foundSiteCalendar(siteCalendar);
    //sleep(10000);
    }
@Test
void calendarTest(){
//получение месяца из даты системы (текущий месяц)
       dataComparison();


}
}
