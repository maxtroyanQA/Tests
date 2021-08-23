package autotests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    //protected WebDriver driver;
    @BeforeEach
    void setUp() {
       // WebDriver driver = WebDriverRunner.getWebDriver();
       // Configuration.browserSize = "1920x1080";
        //WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver(new ChromeOptions().addArguments("--window-size=600,600"));
        //PageFactory.initElements(driver, this);
    }
    @AfterEach
    void exit(){
        //driver.quit();
       //closeWebDriver();


    }
}
