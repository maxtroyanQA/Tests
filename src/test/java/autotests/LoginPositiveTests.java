package autotests;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Позитивный тест")
@ExtendWith(ScreenshotExtension.class)
 public class LoginPositiveTests extends TestBase {

@ParameterizedTest

@DisplayName("Ввод правильного логина и пароля с проверкой авторизации")

@Attachment

@CsvSource(value = {
        "Тест, Т",
        "Авто Пользователь, 12345678"
})

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

//class MyArguments implements ArgumentsProvider {
//
//    public static TypesProperties properties = new TypesProperties();
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
//        return of(properties.LOGIN_TEST1, properties.LOGIN_TEST2,properties.LOGIN_TEST3).map(Arguments::of);
//}
//    @Override
//    public Stream<? extends Arguments> provideArguments (ExtensionContext context) {
//        return of(properties.PASSWORD_TEST1, properties.PASSWORD_TEST2,properties.PASSWORD_TEST3).map(Arguments::of);
//
//    }




