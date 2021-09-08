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

        loginPage.foundSiteCalendar()
                .loadCalendar();
    }

    @Test(description = "Сравнение текущей даты календаря")
    void calendarTest1() {

        try {
        loginPage.comparisonDate()
                .checkWorkDay()
                .checkWeekendDay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Выбор месяца: октябрь")
    void calendarTest2() {

        try {
        loginPage.clickNextMonth()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Выбор пользователя: 'Абдулин Ринат'")
    void calendarTest3() {

            try {
        loginPage.selectAnotherUser()
                .loadCalendar()
                .checkWorkDay()
                .checkWeekendDay();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
