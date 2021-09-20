package assistive;

import autotests.LogTimeTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogTimePages;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestBase {


    public static AuthorizedTestBase authorized;
    public static TypesProperties prop;
    public static LogTimePages logTime;
    public static Properties resource;

    @BeforeMethod
    //Конфигурация браузера
    public void setUp() throws IOException {


        authorized = new AuthorizedTestBase();
        prop = new TypesProperties();
        logTime = new LogTimePages();
        resource = new Properties();
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

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