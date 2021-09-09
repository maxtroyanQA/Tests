package autotests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase{

    protected String SITE = "https://tt-develop.quality-lab.ru";
    protected String COOKIE = "PHPSESSID=5416dfb20f97f250dc8ed6d9d03a6d8e";

    protected SelenideElement BUTTONMENU = $("#m_aside_left_minimize_toggle");
    protected SelenideElement REPORTTODAY = $x("//li[@class = 'm-menu__item ']//a[@href = '/report/group/edit']");
protected SelenideElement REPORT = $x("//span[contains(text(),'Отчеты')]/../../../*[@class = 'm-menu__link-icon flaticon-line-graph']");
protected SelenideElement FINDTEXT = $x("//p[contains(text(),'Вы действительно хотите залогировать данное количество времени?')]/../../../../../../div[@class = 'modal fade show']");


}
