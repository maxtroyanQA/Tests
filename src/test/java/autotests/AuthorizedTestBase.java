package autotests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizedTestBase extends LoginPage{
    @BeforeEach
            void Authorized(){
        //Переход на сайт указанный в LoginPage->site
        open(site);
        //method chaining (цепочки вызовов)
        setLogin(userLogin)
                .setPass(userPassword)
                .buttonClick();
    }

}
