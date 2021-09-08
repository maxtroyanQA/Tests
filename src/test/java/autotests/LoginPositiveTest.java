package autotests;


import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({ScreenShooter.class})
public class LoginPositiveTest extends TestBase {

//    @DataProvider
//    public Object[][] testUser () {
//        return new Object[][] {
//                "Авто Пользователь", "12345678"],
//          ["user1", "1222"]
//     }
//    }

    @Parameters({
            "user", "pwd"})
    @Test(description = "Проверка пользовательских данных")
    public void PositiveTests(String user, String pwd) {

        try {
            //method chaining (цепочки вызовов)
            loginPage.openStartSite()
                    .setLOGIN(user).setPass(pwd)
                    .clickButton()
                    .foundSiteEdit()
                    .clickUserAvatar()
                    .checkLogin()
                    .checkEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

