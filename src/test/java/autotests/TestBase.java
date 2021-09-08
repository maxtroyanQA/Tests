package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class TestBase {
    public static LoginPage loginPage;
    public static AuthorizedTestBase authorized;
    public static TypesProperties properties;
    public static Properties resource;

    //WebDriver driver = new ChromeDriver();
    @BeforeMethod
    //Конфигурация браузера
    void setUp() throws IOException {

        loginPage = new LoginPage();
        authorized = new AuthorizedTestBase();
        resource = new Properties();
        properties = new TypesProperties();


        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));
        //Configuration.timeout = Duration.of(1, ChronoUnit.MINUTES).toMillis();
        // Выбор браузера для открытия
        // Браузер default Chrome
        //Configuration.reportsFolder = "C:\\Users\\WORK\\Tests\\Screenshot";
        Configuration.browser = "chrome";

        // Установка размер окра браузера
        Configuration.startMaximized = true;

        //Configuration.browserSize = "1500x1500";
        // Очистка кэша(форм) от ранних записей
        WebDriverRunner.clearBrowserCache();

        Configuration.timeout = 6000;

        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterMethod
        // Закрытие браузера после теста
    void exit() {
        closeWebDriver();
    }
}
