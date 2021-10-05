package pages;

import assistive.HolidayItem;
import assistive.TestBase;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ApiPages extends TestBase {

    SoftAssert soft = new SoftAssert();


    public void assertAll(List<HolidayItem> items) {

        boolean TYPEID1 = items.stream().anyMatch((s)->s.type_id==1);
        boolean TYPEID2 = items.stream().anyMatch((s)->s.type_id==2);
        boolean TYPEIDNO = items.stream().anyMatch((s)->s.type_id>2 || s.type_id<1);

        soft.assertTrue(TYPEID1, "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertTrue(TYPEID2, "не найдено ни одного дня с типом SHORT_DAY");
        soft.assertFalse(TYPEIDNO, "Найден день неизвестного типа");
        soft.assertAll();
    }


    public void assertHoly(List<HolidayItem> items) {

        boolean TYPEID2 = items.stream().anyMatch((s)->s.type_id==2);
        boolean TYPEIDNO = items.stream().anyMatch((s)->s.type_id>2 || s.type_id<1);

        soft.assertTrue(TYPEID2, "не найдено ни одного дня с типом SHORT_DAY");
        soft.assertFalse(TYPEIDNO, "Найден день неизвестного типа");
        soft.assertAll();
    }


    public void assertShort(List<HolidayItem> items) {

        boolean TYPEID1 = items.stream().anyMatch((s)->s.type_id==1);
        boolean TYPEIDNO = items.stream().anyMatch((s)->s.type_id>2 || s.type_id<1);

        soft.assertTrue(TYPEID1, "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertFalse(TYPEIDNO, "Найден день неизвестного типа");
        soft.assertAll();
    }
}