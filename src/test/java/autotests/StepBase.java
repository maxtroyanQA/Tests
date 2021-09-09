package autotests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StepBase extends TestBase{

    @Step("Нажатие на выпадающее меню")
        // Метод нажатия на выпадающее меню
    StepBase clickMenu() {

        loginPage.BUTTONMENU.shouldBe(visible
                .because("Меню должно быть видимым")).click();
        return this;
    }

    @Step("Нажатие на 'Отчет за сегодня'")
    StepBase clickReportToday() {
loginPage.REPORTTODAY.click();
        return this;
    }

    @Step("Нажатие на 'Отчеты'")
    StepBase clickReport(){
        loginPage.REPORT.click();
        return this;
    }

    @Step("Нажатие на эмоцию")
    @Parameters({"emotion"})
    StepBase clickEmotion(int emotion){
        $x("//div[@emotion-id='"+emotion+"']").click();
        return this;
    }

    @Step("Поиск текста на всплывающем окне")
    StepBase findText(){
        $(loginPage.FINDTEXT).shouldBe(visible.because("Надписи нет"));
        return this;
    }
}
