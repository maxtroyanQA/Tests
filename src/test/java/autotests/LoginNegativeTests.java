package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


class LoginNegativeTests extends TestBase{


    @Test
    void incorrectUserNameAndPassword() throws Exception {

open(properties.startSITE);
        loginPage.ALLPAGE.shouldNot(Condition.text(loginPage.FOUNDTEXT));

        Assertions.assertEquals(url(), loginPage.SITELOGIN);
        loginPage.setWrongLogin()
                .setWrongPass()
                .clickButton();

        loginPage.ALLPAGE.shouldHave(Condition.text(loginPage.FOUNDTEXT));

    }
}
