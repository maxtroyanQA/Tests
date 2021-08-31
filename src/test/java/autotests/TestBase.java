package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    public static LoginPage loginPage;
    public static AuthorizedTestBase authorized;
    public static TypesProperties properties;
    public static Properties resource;

    @BeforeEach
    //Конфигурация браузера
    void setUp() throws IOException {
        loginPage = new LoginPage();
        authorized = new AuthorizedTestBase();
        resource = new Properties();
        properties = new TypesProperties();

        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));

        // Выбор браузера для открытия
        // Браузер default Chrome
        Configuration.browser = "opera";
        // Установка размер окра браузера
        Configuration.browserSize = "1500x1500";
        // Очистка кэша(форм) от ранних записей
        WebDriverRunner.clearBrowserCache();


    }

    @AfterEach
    // Закрытие браузера после теста
    void exit(){
       closeWebDriver();
    }


}
