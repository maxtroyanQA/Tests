package assistive;

import pages.ApiPages;
import pages.CalendarPage;
import pages.HomePage;
import pages.LoginPage;
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

    // Объявление переменной типа класса
    public static Properties resource;
    public static LoginPage loginPage;
    public static AuthorizedTestBase authorized;
    public static TypesProperties properties;
    public static CalendarPage calendarPage;
    public static HomePage homePage;
    public static ApiPages apiPages;
    public static CheckWorkWeekendDay checkWorkWeekendDay;
    public static DataProvider dataProvider;
    public static HolidayItem holidayItem;


    @BeforeMethod

    /** Конфигурация браузера */
    public void setUp() throws IOException {

        // Создание экземпляров классов
        resource = new Properties();
        loginPage = new LoginPage();
        authorized = new AuthorizedTestBase();
        properties = new TypesProperties();
        calendarPage = new CalendarPage();
        homePage = new HomePage();
        apiPages = new ApiPages();
        checkWorkWeekendDay = new CheckWorkWeekendDay();
        dataProvider = new DataProvider();
        holidayItem = new HolidayItem();

        // Подключение app.properties
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        /* Выбор браузера для открытия
         Браузер default Chrome */
        properties.environments();
        Configuration.browser = properties.environments();

        // Установка размер окра браузера
        Configuration.startMaximized = true;
        //Configuration.browserSize = "1500x1500";

        // Очистка кэша(форм) от ранних записей
        WebDriverRunner.clearBrowserCache();

        // Тайм-аут загрузки страницы
        Configuration.timeout = 10000;

        // Настройка слушателя (selenide ScreenShooter)
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
