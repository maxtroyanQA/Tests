package assistive;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class CheckWorkWeekendDay {


    //Locators

    private final SelenideElement ALLDAYCALENDAR =
            $x("//td[@class='fc-event-container']");

    //Variables
    private final String WORKDAYXPATH =
            "//div[@class = 'fc-content-skeleton']/descendant::" +
                    "tbody/tr[1]/td/a[contains(@class, 'schedule-badge--default')]";

    private final String WEEKENDDAYXPATH =
            "//div[@class = 'fc-content-skeleton']/descendant::" +
                    "tbody/tr/td/a[contains(@class, 'schedule-badge--no-event')]";


    @Step("Проверка наличия рабочих/выходных дней")

    /** Метод проверки рабочих/выходных дней */
    public CheckWorkWeekendDay checkWorkWeekendDay() {

        List<WebElement> workDays = ALLDAYCALENDAR.findElements
                (By.xpath(WORKDAYXPATH));
        List<WebElement> weekendDays = ALLDAYCALENDAR.findElements
                (By.xpath(WEEKENDDAYXPATH));

        if (workDays.size() > 0) {
            System.out.println("Количество рабочих дней: " + workDays.size());
        } else {
            System.out.println("Рабочих дней нет");
        }
        Assert.assertNotEquals(workDays.size(), 0);

        if (weekendDays.size() > 0) {
            System.out.println("Количество выходных дней: " + weekendDays.size());
        } else {
            System.out.println("Выходных дней нет");
        }

        Assert.assertNotEquals(workDays.size(), 0);

        return this;
    }
}
