package autotests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Позитивный тест2")
@ExtendWith(ScreenShooterExtension.class)
public class LoginPositiveTests extends TestBase {

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "Тест, Т",
            "Авто Пользователь, 12345678"
    })
    @DisplayName("Ввод правильного логина и пароля с проверкой авторизации")
    public void PositiveTests(String login, String pass) {

        open(properties.startSITE);     //Переход на сайт указанный

        //method chaining (цепочки вызовов)
        loginPage.setLOGIN(login).setPass(pass)
                .clickButton();

        loginPage.foundSiteEdit(loginPage.SITEEDIT)
                .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        loginPage.NAME.shouldHave(Condition.text(loginPage.USERLOGIN));
        loginPage.EMAIL.shouldHave(Condition.text(loginPage.USEREMAIL));

    }

}






