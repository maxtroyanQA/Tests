package autotests;


import assistive.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import pages.LogTimePages;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Resources.getResource;
import static java.io.File.createTempFile;


@Listeners({ReportPortalTestNGListener.class, ScreenShooter.class, TestListenerAdapter.class})
public class LogTimeTest extends TestBase {
    private WebDriverRunner driver;
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTimePages.class);

    @BeforeMethod (description = "Авторизация")
    @Parameters({"login", "pass"})
    void preconditionCalendarTest(String login, String pass) throws IOException {

        authorized.authorizedCookie(login, pass);
    }

    @Parameters({"emotion"})
    @Test(description = "Тест пользователей")
    public void UserTest(int emotion) throws IOException {

        LOGGER.info("Start Test");


        logTime.openStartSIte()
                .clickMenu()
                .clickReport()
                .clickReportToday()
                .clickEmotion(emotion)
                .findText()
                .clickCancel();

        LOGGER.info("End Test");

    }



}

