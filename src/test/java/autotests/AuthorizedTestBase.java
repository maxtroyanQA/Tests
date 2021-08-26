package autotests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;


public class AuthorizedTestBase extends LoginPage{
    @BeforeEach
    void Authorized(){

        open(SITE);     //Переход на сайт указанный в LoginPage->SITE

        //method chaining (цепочки вызовов)
        setLOGIN(USERLOGIN)
                .setPass(USERPASSWORD)
                .clickButton();
    }
}
