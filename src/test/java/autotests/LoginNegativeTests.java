package autotests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;


@Listeners({ ScreenShooter.class})

public class LoginNegativeTests extends TestBase {


    @Test
    void incorrectUserNameAndPassword() {

        open(properties.startSITE);
        loginPage.ALLPAGE.shouldNot(Condition.text(loginPage.FOUNDTEXT));

        webdriver().shouldHave(WebDriverConditions.url(loginPage.SITELOGIN));
        loginPage.setWrongLogin()
                .setWrongPass()
                .clickButton();

        //loginPage.ALLPAGE.shouldBe(Condition.text(loginPage.FOUNDTEXT));
        loginPage.ALLPAGE.shouldHave(Condition.text(loginPage.FOUNDTEXT));

    }
}
