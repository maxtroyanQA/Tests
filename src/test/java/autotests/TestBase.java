package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    //protected WebDriver driver;
    @BeforeEach
    void setUp() {
        //Установка браузера открытия
        // браузер default Chrome
        Configuration.browser = "chrome";
        //Установка размер окра браузера
        Configuration.browserSize = "1500x1500";
        //Очистка кэша(форм) от ранних записей
        WebDriverRunner.clearBrowserCache();

       // WebdriverRunner.clearBrowserCache();
       // WebDriver driver = WebDriverRunner.getWebDriver();
       // Configuration.browserSize = "1920x1080";
        //WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver(new ChromeOptions().addArguments("--window-size=600,600"));
        //PageFactory.initElements(driver, this);
    }
    @AfterEach
    void exit(){
        //driver.quit();
       closeWebDriver();


    }
}
