package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

@ExtendWith(ScreenshotExtension.class)
@DisplayName("Негативный тест")
class LoginNegativeTests extends TestBase {

    @Test
    @DisplayName("Ввод неправильного логина и пароля")
    void incorrectUserNameAndPassword() {

        open(properties.startSITE);
        loginPage.ALLPAGE.shouldNot(Condition.text(loginPage.FOUNDTEXT));

        Assertions.assertEquals(url(), loginPage.SITELOGIN);
        loginPage.setWrongLogin()
                .setWrongPass()
                .clickButton();

        loginPage.ALLPAGE.shouldHave(Condition.text(loginPage.FOUNDTEXT));

    }
}
