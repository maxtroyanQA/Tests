package autotests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Позитивный тест3")

public class LoginPositiveTests extends TestBase {
    @ExtendWith(ScreenshotExtension.class)

//    public void takePhotoByAllure(WebDriver driver){
//        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//        Allure.addAttachment("Скриншот", new ByteArrayInputStream(screenshotAs));
//    }
    @ParameterizedTest
    @CsvSource(value = {
            "Тест, Т",
            "Авто Пользователь, 12345678"
    })
    @DisplayName("Ввод правильного логина и пароля с проверкой авторизации")
    public void PositiveTests(String login, String pass) {
try {
    open(properties.startSITE);     //Переход на сайт указанный

    //method chaining (цепочки вызовов)
    loginPage.setLOGIN(login).setPass(pass)
            .clickButton();

    loginPage.foundSiteEdit(loginPage.SITEEDIT)
            .clickUserAvatar();
    //сравнение введенного имени пользователя и пароля
    loginPage.NAME.shouldHave(Condition.text(loginPage.USERLOGIN));
    loginPage.EMAIL.shouldHave(Condition.text(loginPage.USEREMAIL));
}catch (Exception e){
    e.printStackTrace();
}
    }

//    @Attachment
//    public String performedActions(ActionSequence actionSequence) {
//        return actionSequence.toString();
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }

}






