package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestBase {
    public static LoginPage loginPage;
    public static AuthorizedTestBase authorized;
    public static Properties resource;
    public static UserTests userTests;
    public static StepBase step;

    //WebDriver driver = new ChromeDriver();
    @BeforeMethod
    //Конфигурация браузера
    void setUp() throws IOException {

        loginPage = new LoginPage();
        authorized = new AuthorizedTestBase();
        userTests = new UserTests();
        step = new StepBase();
        resource = new Properties();

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        WebDriverRunner.clearBrowserCache();
        Configuration.timeout = 60000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterMethod
    void exit() {
        closeWebDriver();
    }
}