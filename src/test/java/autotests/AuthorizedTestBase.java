package autotests;

import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;


public class AuthorizedTestBase extends LoginPage{

    public static TypesProperties properties;
    public static Properties resource;

    @BeforeEach
    public  void initProperties() throws Exception {
        resource = new Properties();
        resource.load(ClassLoader.getSystemResourceAsStream("app.properties"));
        properties = new TypesProperties();
    }

    @BeforeEach
    void Authorized() {

        open(properties.SITE);     //Переход на сайт указанный в LoginPage->SITE

        //method chaining (цепочки вызовов)
        setLOGIN(properties.LOGIN)
                .setPass(properties.PASSWORD)
                .clickButton();
    }
}

