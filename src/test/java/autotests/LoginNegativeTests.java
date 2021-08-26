package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


class LoginNegativeTests extends LoginPage {


    @Test
    void incorrectUserNameAndPassword() {
        open(SITE);

        ALLPAGE.shouldNot(Condition.text(FOUNDTEXT));

        Assertions.assertEquals(url(), SITELOGIN);
        setWrongLogin()
                .setWrongPass()
                .clickButton();

        ALLPAGE.shouldHave(Condition.text(FOUNDTEXT));

    }
}
