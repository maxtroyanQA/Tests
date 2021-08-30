package autotests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginPositiveTests extends TestBase {
    TypesProperties properties = new TypesProperties();
    @Test
    void PositiveTests() throws Exception {
        open(properties.startSITE);     //Переход на сайт указанный

        //method chaining (цепочки вызовов)
        loginPage.setLOGIN(loginPage.USERLOGIN)
                .setPass(loginPage.USERPASSWORD)
                .clickButton();

        loginPage.foundSiteEdit(loginPage.SITEEDIT)
                 .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        loginPage.NAME.shouldHave(Condition.text(loginPage.USERLOGIN));
        loginPage.EMAIL.shouldHave(Condition.text(loginPage.USEREMAIL));
    }

}
