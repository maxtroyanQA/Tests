package autotests;

import assistive.AuthorizedTestBase;
import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners({ScreenShooter.class})
public class LogTimeTest extends TestBase {

    @BeforeMethod
    @Parameters({"login", "pass"})
    void preconditionCalendarTest(String login, String pass) throws IOException {

        authorized.authorizedCookie(login, pass);
    }

    @Parameters({"emotion"})
    @Test(description = "Тест пользователей")
    public void UserTest(int emotion) {


        logTime.openStartSIte()
                .clickMenu()
                .clickReport()
                .clickReportToday()
                .clickEmotion(emotion)
                .findText()
                .clickCancel();
    }
}

