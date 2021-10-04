package assistive;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestBase {


    public static AuthorizedTestBase authorized;
    public static TypesProperties prop;
    public static LogTimePages logTime;
    public static Properties resource;
    public static DriverManager driverManager;

    @BeforeMethod
    public void setUp() throws IOException {

        authorized = new AuthorizedTestBase();
        prop = new TypesProperties();
        logTime = new LogTimePages();
        resource = new Properties();
        driverManager = new DriverManager();
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        driverManager.DriverManager();






        //Configuration.startMaximized = true;
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