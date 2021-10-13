package assistive;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LogTimePages;

import java.io.IOException;
import java.util.Properties;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class TestBase {


    public static AuthorizedTestBase authorized;
    public static TypesProperties prop;
    public static LogTimePages logTime;
    public static Properties resource;
    public static DriverManagerSelenoid driverManagerSelenoid;
    public static DriverManagerSeleniumGrid driverManagerSeleniumGrid;

   // public RemoteWebDriver driver;

    @BeforeMethod
    @Parameters("dataBrowser")
    public void setUp(String dataBrowser) throws IOException {

        authorized = new AuthorizedTestBase();
        prop = new TypesProperties();
        logTime = new LogTimePages();
        resource = new Properties();
        driverManagerSelenoid = new DriverManagerSelenoid();
        driverManagerSeleniumGrid = new DriverManagerSeleniumGrid();

        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        // Запуск в Selenoid
        driverManagerSelenoid.driverManagerSelenoid(dataBrowser);

//Configuration.browser = browserName;

        //Запуск в SeleniumGrid
      //  driverManagerSeleniumGrid.driverManagerSeleniumGrid();
//

        //Configuration.startMaximized = true;
        WebDriverRunner.clearBrowserCache();
        Configuration.timeout = 100000;


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterMethod
    void exit() {
        //driver.close();
        // driver.quit();

//         WebDriverRunner.driver().close();
//
//        driver.quit();
//        driver.close();
        closeWebDriver();

        //  WebDrive

    }
}