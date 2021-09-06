package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@DisplayName("Позитивный тест")
@ExtendWith(ScreenShooterExtension.class)
public class LoginPositiveTests extends TestBase {


    @ParameterizedTest
    @CsvSource(value = {
            "Авто, 1234",
            "Авто Пользователь, 12345678"})

    @DisplayName("Ввод правильного логина и пароля с проверкой авторизации")
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

