package autotests;

import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})

public class LoginNegativeTest extends TestBase {


    @Parameters({
            "WRONGUSER", "WRONGPASS"})
    @Test(description = "Проверка появления надписи 'Invalid credentials.'")
    void incorrectUserNameAndPassword(String WRONGUSER, String WRONGPASS) {

        try {
            loginPage.openStartSite()
                    .checkNotInvalid()
                    .checkSiteLogin()
                    .setWrongLogin(WRONGUSER)
                    .setWrongPass(WRONGPASS)
                    .clickButton()
                    .checkInvalid()
                    .poleLogin(WRONGUSER)
                    .polePass();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
