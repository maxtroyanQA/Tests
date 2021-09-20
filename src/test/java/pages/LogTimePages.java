package pages;

import assistive.TestBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LogTimePages extends TestBase {

    //CSS и XPath локаторы
    protected SelenideElement BUTTONMENU = $("#m_aside_left_minimize_toggle");
    protected SelenideElement REPORTTODAY = $x("//li[@class = " +
            "'m-menu__item ']//a[@href = '/report/group/edit']");
    protected SelenideElement REPORT = $x("//a[@class = " +
            "'m-menu__link m-menu__toggle']//child::span[contains(text(),'Отчеты')]");
    protected SelenideElement FINDTEXT = $x("//div[@class = 'modal fade show']" +
            "//child::p[contains(text()," +
            "'Вы действительно хотите залогировать данное количество времени?')]");


    @Step("Нажатие на выпадающее меню")
    // Метод нажатия на выпадающее меню
    public LogTimePages clickMenu() {

        BUTTONMENU.shouldBe(visible
                .because("Меню должно быть видимым")).click();

        return this;
    }


    @Step("Нажатие на 'Отчет за сегодня'")
    public LogTimePages clickReportToday() {
        REPORTTODAY.click();

        return this;
    }


    @Step("Нажатие на 'Отчеты'")
    public LogTimePages clickReport() {
        REPORT.click();

        return this;
    }


    @Step("Нажатие на эмоцию")
    @Parameters({"emotion"})
    public LogTimePages clickEmotion(int emotion) {
        $x("//div[@emotion-id='" + emotion + "']").click();

        return this;
    }


    @Step("Поиск текста на всплывающем окне")
    public LogTimePages findText() {
        $(FINDTEXT).shouldBe(visible.because("Надписи нет"));

        return this;
    }


    @Step("Нажатие кнопки 'Отмена' в всплывающем окне")
    public LogTimePages clickCancel() {
        $x("//div[@id = 'modal-more-less-hours']" +
                "//child::button[@class = 'btn btn-secondary']").click();

        return this;
    }

    @Step("Открыть URL:...+ /report/group/edit")
    public LogTimePages openStartSIte() {
        open(prop.SITE_P + "/report/group/edit");

        return this;
    }
}
