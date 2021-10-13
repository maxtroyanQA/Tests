package assistive;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManagerSeleniumGrid {
    WebDriver driver;
    String nodeURL;

    public void driverManagerSeleniumGrid() throws MalformedURLException {
        nodeURL = "http://192.168.1.192:5555/wd/hub";
        System.out.println("Internet Browser Initiated");
        DesiredCapabilities capabilities2 = DesiredCapabilities.internetExplorer();
        capabilities2.setBrowserName("internet explorer");
        capabilities2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities2.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities2.setCapability("ignoreProtectedModeSettings", true);
        capabilities2.setCapability("nativeEvents", false);
        capabilities2.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
        capabilities2.setCapability(InternetExplorerDriver.LOG_LEVEL, "DEBUG");


        capabilities2.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL(nodeURL), capabilities2);
        WebDriverRunner.setWebDriver(driver);
    }


}