package autotests;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;


public class AuthorizedTestBase extends TestBase{



//  @BeforeEach
//    public  void initProperties() throws Exception {
//
//    }

    @BeforeEach

    void Authorized() {

       //System.out.println(System.getenv("URL_E"));

      //  System.out.println(properties.LOGIN);
        open(properties.startSITE);     //Переход на сайт указанный в LoginPage->SITE

        //method chaining (цепочки вызовов)
        loginPage.setLOGIN(properties.LOGIN_P)
                 .setPass(properties.PASSWORD_P)
                 .clickButton();
    }

}


