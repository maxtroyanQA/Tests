package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

//
//public class Util {
//    @BeforeAll
//    public String getPropertyValue(String propertyName){
//        String propertyValue = "";
//        Properties properties = new Properties();
//
//        try (InputStream inputStream = this.getClass().getResourceAsStream("app.properties")){
//            properties.load(inputStream);
//            propertyValue = properties.getProperty(propertyName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return propertyValue;
//    }
//}
public class TestBase {

    @BeforeEach
    //Конфигурация браузера
    void setUp() {
        // Выбор браузера для открытия
        // Браузер default Chrome
        Configuration.browser = "chrome";
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
