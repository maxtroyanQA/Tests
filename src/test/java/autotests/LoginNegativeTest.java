package autotests;

import assistive.DataProvider;
import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})

public class LoginNegativeTest extends TestBase {


    @Test(description = "Проверка появления надписи 'Invalid credentials.'",
            dataProvider = "dataWrongUser",
            dataProviderClass = DataProvider.class)
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


    @Test
    void withoutUserNameAndPassword() {
        try {
            loginPage.openStartSite()
                    .clickButton()
                    .checkNotInvalid()
                    .checkSiteLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

