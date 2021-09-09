package autotests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;

@Listeners({ScreenShooter.class})
public class UserTests extends TestBase{

    @BeforeMethod
    @Parameters({"login", "pass"})
    void preconditionCalendarTest(String login, String pass) throws IOException {

        AuthorizedTestBase.authorized.authorizedCookie(login, pass);
    }
@Parameters({"emotion"})
    @Test(description = "Тест пользователей")
    public void UserTest (int emotion){

        try {
            step.clickMenu()
                    .clickReport()
                    .clickReportToday()
                    .clickEmotion(emotion)
                    .findText();
            sleep(10000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
