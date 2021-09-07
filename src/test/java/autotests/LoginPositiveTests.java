package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


@Listeners({ScreenShooter.class})
public class LoginPositiveTests extends TestBase {

    @Parameters({
            "user", "pwd"})
    @Test(description = "Проверка пользовательских данных")
    public void PositiveTests(String user, String pwd) {

        try {
            //Переход на сайт указанный
            open(properties.startSITE);

            //method chaining (цепочки вызовов)
            loginPage.setLOGIN(user).setPass(pwd)
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

