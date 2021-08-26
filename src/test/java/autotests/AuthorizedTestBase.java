package autotests;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

import java.io.IOException;
import java.util.Properties;




public class AuthorizedTestBase extends LoginPage{
    public static Properties properties;

    public static Properties resource;
    @BeforeEach
    public static void initProperties() throws Exception {

    }



    @BeforeEach
    void Authorized() throws Exception {
        resource = new Properties();
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));
        properties = new Properties();

        open(properties.SITE);     //Переход на сайт указанный в LoginPage->SITE

        //method chaining (цепочки вызовов)
        setLOGIN(USERLOGIN)
                .setPass(USERPASSWORD)
                .clickButton();
    }
}

