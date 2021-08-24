package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

class LoginNegativeTests extends LoginPage {


    @Test
    void incorrectUserNameAndPassword() {

            //Переход на сайт указанный в LoginPage->site
            open(site);

            allPage.shouldNot(Condition.text(foundText));
            Assertions.assertEquals(url(), siteLogin);
            setWrongLogin()
                    .setWrongPass()
                    .buttonClick();

            allPage.shouldHave(Condition.text(foundText));

    }
}
