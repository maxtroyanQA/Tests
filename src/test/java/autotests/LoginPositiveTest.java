package autotests;


import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})
public class LoginPositiveTest extends TestBase {


    @Parameters({
            "USER", "PASS"})
    @Test(description = "Проверка пользовательских данных")

    public void PositiveTests(String USER, String PASS) {


        //method chaining (цепочки вызовов)
        loginPage.openStartSite()
                .setLOGIN(USER)
                .setPass(PASS)
                .clickButton();

        homePage.foundSiteEdit()
                .clickUserAvatar()
                .checkLogin()
                .checkEmail();
    }
}

