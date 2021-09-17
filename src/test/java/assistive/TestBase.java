package assistive;

import Pages.ApiPages;
import Pages.CalendarPage;
import Pages.HomePage;
import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public abstract class TestBase {

    public static Properties resource;
    public static LoginPage loginPage;
    public static AuthorizedTestBase authorized;
    public static TypesProperties properties;
    public static CalendarPage calendarPage;
    public static HomePage homePage;
    public static ApiPages apiPages;


    @BeforeMethod

    /** Конфигурация браузера */
    public void setUp() throws IOException {

        resource = new Properties();
        loginPage = new LoginPage();
        authorized = new AuthorizedTestBase();
        properties = new TypesProperties();
        calendarPage = new CalendarPage();
        homePage = new HomePage();
        apiPages = new ApiPages();

        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        /* Выбор браузера для открытия
         Браузер default Chrome */
        Configuration.browser = "chrome";

        // Установка размер окра браузера
        Configuration.startMaximized = true;
        //Configuration.browserSize = "1500x1500";

        // Очистка кэша(форм) от ранних записей
        WebDriverRunner.clearBrowserCache();

        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterMethod

    /** Закрытие браузера после теста */
    void exit() {
        closeWebDriver();
    }


}
