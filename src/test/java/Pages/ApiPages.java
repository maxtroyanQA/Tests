package Pages;

import assistive.TestBase;
import org.testng.asserts.SoftAssert;

public class ApiPages extends TestBase {

    SoftAssert soft = new SoftAssert();


    public void assertHolyShort(boolean holyDayFound, boolean shortDayFound) {

        soft.assertTrue(holyDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertTrue(shortDayFound,
                "не найдено ни одного дня с типом SHORT_DAY");
        soft.assertAll();
    }


    public void assertHoly(boolean holyDayFound) {

        soft.assertTrue(holyDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertAll();
    }


    public void assertShort(boolean shortDayFound) {

        soft.assertTrue(shortDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertAll();
    }
}
