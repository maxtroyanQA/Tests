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
        switch(runType)

    {
        /**
         * Для запусков тестов через терминал
         * с указанием необходимого браузера,
         * использовать команду: mvn test -Dbrowser=chrome.
         * По умолчанию запуск происходит в браузере 'Opera'
         */
        case ("local"):
         //   Configuration.browser = BROWSER;
           // Configuration.browser = "Firefox";
            Configuration.browserPosition = "1921x0";
            Configuration.browserSize = "1800x1000";
            Configuration.browser = System.getProperty("browser", "opera");
            Configuration.browserVersion = "80.0";
           //
            break;


        case ("opera"):
            capabilities.setBrowserName("opera");
            capabilities.setVersion("79.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);


            driver = new RemoteWebDriver(
                    URI.create("http://192.168.1.116:8080/wd/hub").toURL(),
                    capabilities
            );
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);
            Configuration.timeout = 100000;

            break;

//        case ("chrome"):
//            capabilities.setBrowserName("chrome");
//            capabilities.setVersion("93.0");
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", false);
//
//            driver = new RemoteWebDriver(
//                    URI.create("http://192.168.1.116:8080/wd/hub").toURL(),
//                    capabilities
//            );
//            driver.manage().window().maximize();
//            WebDriverRunner.setWebDriver(driver);
//            Configuration.timeout = 100000;
//
//            break;

        case ("firefox"):
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("92.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://192.168.1.116:8080/wd/hub").toURL(),
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
