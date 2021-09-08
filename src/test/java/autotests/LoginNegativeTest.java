package autotests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})

public class LoginNegativeTest extends TestBase {


    @Test(description = "Проверка появления надписи 'Invalid credentials.'")
    void incorrectUserNameAndPassword() {

        try {
            loginPage.openStartSite()
                    .checkNotInvalid()
                    .checkSiteLogin()
                    .setWrongLogin()
                    .setWrongPass()
                    .clickButton()
                    .checkInvalid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
