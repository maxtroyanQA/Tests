package autotests;

import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ScreenShooter.class})
public class CalendarTests extends TestBase {


    @BeforeMethod
    public void preconditionCalendarTest() throws IOException {

        authorized.authorizedCookie();
    }

    @Test(description = "Сравнение текущей даты календаря")
    public void calendarTest1() {

        try {
            calendarPage.openSiteCalendar()
                    .foundSiteCalendar()
                    .loadCalendar()
                    .comparisonDate();
            checkWorkWeekendDay.checkWorkWeekendDay();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Выбор месяца: октябрь")
    public void calendarTest2() {

        try {
            calendarPage.openSiteCalendar()
                    .foundSiteCalendar()
                    .loadCalendar()
                    .clickNextMonth()
                    .loadCalendar();
            checkWorkWeekendDay.checkWorkWeekendDay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameters({"NEWUSERCALENDAR"})
    @Test(description = "Выбор в календаре другого пользователя")
    public void calendarTest3(String NEWUSERCALENDAR) {

        try {
            calendarPage.openSiteCalendar()
                    .foundSiteCalendar()
                    .loadCalendar()
                    .selectAnotherUser(NEWUSERCALENDAR)
                    .loadCalendar();
            checkWorkWeekendDay.checkWorkWeekendDay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
