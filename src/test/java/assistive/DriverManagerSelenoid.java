package assistive;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManagerSelenoid extends TestBase{

@BeforeMethod

public void driverManagerSelenoid ( String dataBrowser) throws MalformedURLException {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    RemoteWebDriver driver;
    String runType = dataBrowser;
        switch("local")

    {

        case ("local"):
         //   Configuration.browser = BROWSER;
           // Configuration.browser = "Firefox";
            Configuration.browserPosition = "1921x0";
            Configuration.browserSize = "1800x1000";

            break;


        case ("docker_opera"):
            capabilities.setBrowserName("opera");
            capabilities.setVersion("69.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            capabilities.setCapability("screenResolution","1920x1080x24");

            driver = new RemoteWebDriver(
                    URI.create("http://130.193.52.162:8080/wd/hub").toURL(),
                    capabilities
            );
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 100000;

            break;

        case ("docker_chrome"):
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("84.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://130.193.52.162:8080/wd/hub").toURL(),
                    capabilities
            );
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 100000;

            break;

        case ("docker_firefox"):
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("77.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://130.193.52.162:8080/wd/hub").toURL(),
                    capabilities
            );
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 100000;

            break;

    }
}

// case ("docker_firefox"):
//         capabilities.setBrowserName("firefox");
//            capabilities.setVersion("77.0");
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", false);
//
//    driver = new RemoteWebDriver(
//            URI.create("http://192.168.1.116:8080/wd/hub").toURL(),
//    capabilities
//            );
//            driver.manage().window().maximize();
//            WebDriverRunner.setWebDriver(driver);
//    Configuration.timeout = 100000;
//
//            break;

//    public String environments() {
//
//        String ENV = System.getenv("BROWSER_ENV");
//        String BROWSERSET;
//
//        if (ENV == null) {
//            BROWSERSET = prop.BROWSER;
//        } else {
//            if (ENV.equals("")) {
//                BROWSERSET = prop.BROWSER;
//            } else BROWSERSET = ENV;
//        }
//
//        return BROWSERSET;
//
//    }


}
