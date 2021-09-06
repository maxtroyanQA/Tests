package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


@Listeners({ ScreenShooter.class})
public class LoginPositiveTests extends TestBase {

@Parameters({
        "Авто", "1234"})

    @Test
    public void PositiveTests(String login, String pass) {

        try {
            //Переход на сайт указанный
            open(properties.startSITE);

            //method chaining (цепочки вызовов)
            loginPage.setLOGIN(login).setPass(pass)
                    .clickButton();

            webdriver().shouldHave(url(loginPage.SITEEDIT));

            loginPage.clickUserAvatar();
            //сравнение введенного имени пользователя и пароля
            loginPage.NAME.shouldHave(Condition.text(loginPage.USERLOGIN));
            loginPage.EMAIL.shouldHave(Condition.text(loginPage.USEREMAIL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

