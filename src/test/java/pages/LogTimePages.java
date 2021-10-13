package pages;

import assistive.TestBase;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


@Listeners({ReportPortalTestNGListener.class, ScreenShooter.class, TestListenerAdapter.class})
public class LogTimePages extends TestBase {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogTimePages.class);

    //CSS и XPath локаторы
    protected SelenideElement BUTTONMENU = $x("//a[@id='m_aside_left_minimize_toggle']");
    protected SelenideElement REPORTTODAY = $x("//li[@class = " +
            "'m-menu__item ']//a[@href = '/report/group/edit']");
    protected SelenideElement REPORT = $x("//a[@class = " +
            "'m-menu__link m-menu__toggle']//child::span[contains(text(),'Отчеты')]");
    protected SelenideElement FINDTEXT = $x("//div[@class = 'modal fade show']" +
            "//child::p[contains(text()," +
            "'Вы действительно хотите залогировать данное количество времени?')]");


    @Step("Нажатие на выпадающее меню!")
    // Метод нажатия на выпадающее меню
    public LogTimePages clickMenu() {

        BUTTONMENU.click();

        LOGGER.info("Нажатие на выпадающее меню");

        return this;
    }


    @Step("Нажатие на 'Отчет за сегодня'")
    public LogTimePages clickReportToday() {
        REPORTTODAY.click();

        LOGGER.info("Нажатие на 'Отчет за сегодня'");

        return this;
    }


    @Step("Нажатие на 'Отчеты'")
    public LogTimePages clickReport() {
        REPORT.click();

        LOGGER.info("Нажатие на 'Отчеты'");

        return this;
    }


    @Step("Нажатие на эмоцию")
    @Parameters({"emotion"})
    public LogTimePages clickEmotion(int emotion) {
        $x("//div[@emotion-id='" + emotion + "']").click();

        LOGGER.info("Нажатие на эмоцию");

        return this;
    }


    @Step("Поиск текста на всплывающем окне")
    public LogTimePages findText() {
        $(FINDTEXT).shouldBe(visible.because("Надписи нет"));

        LOGGER.info("Поиск текста на всплывающем окне");

        return this;
    }


    @Step("Нажатие кнопки 'Отмена' в всплывающем окне")
    public LogTimePages clickCancel() {
        $x("//div[@id = 'modal-more-less-hours']" +
                "//child::button[@class = 'btn btn-secondary']").click();

        LOGGER.info("Нажатие кнопки 'Отмена' в всплывающем окне");

        return this;
    }

    @Step("Открыть URL:...+ /report/group/edit")
    public LogTimePages openStartSIte() {
        open(prop.SITE + "/report/group/edit");

        LOGGER.info("Открыть URL:...+ /report/group/edit");

        return this;
    }
}
