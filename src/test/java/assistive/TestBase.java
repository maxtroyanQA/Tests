package assistive;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.LogTimePages;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestBase {


    public static AuthorizedTestBase authorized;
    public static TypesProperties prop;
    public static LogTimePages logTime;
    public static Properties resource;


    @BeforeMethod
    public void setUp() throws IOException {

        authorized = new AuthorizedTestBase();
        prop = new TypesProperties();
        logTime = new LogTimePages();
        resource = new Properties();
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        String ENV = System.getenv("BROWSER_ENV");
        String browser;
        if (ENV.equals("Chrome") || ENV.equals("Opera") || ENV.equals("IE")) {
             browser = ENV;
        }
        else
        {browser = prop.BROWSER_P;}

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "93.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );

        // Configuration.browser = browser;
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