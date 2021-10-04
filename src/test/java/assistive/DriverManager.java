package assistive;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager extends TestBase{
public void DriverManager () throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    RemoteWebDriver driver;
    String runType = "docker_opera";
        switch(runType)

    {

        case ("local"):
            Configuration.browser = "opera";
            Configuration.browserPosition = "1921x0";
            Configuration.browserSize = "1800x1000";

            break;

        case ("docker_opera"):
            capabilities.setBrowserName("opera");
            capabilities.setVersion("79.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);

            break;

        case ("docker_chrome"):
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("93.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);

            break;

        case ("docker_firefox"):
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("91.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);

            break;

    }
}
}
