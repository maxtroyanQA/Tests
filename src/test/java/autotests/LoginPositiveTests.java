package autotests;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.open;


 class LoginPositiveTests extends TestBase {


String a="Test";
String b="Test1";

     //
//    private static Object[] data(){
//        return new Object[][]{
//                {properties.LOGIN_TEST1,properties.PASSWORD_TEST1},
//                {properties.LOGIN_TEST2,properties.PASSWORD_TEST2},
//                {properties.LOGIN_TEST3,properties.PASSWORD_TEST3}
//        };
//    }
//     @Test
//     @Parameterized.Parameters
//     public static Collection4 primeNumbers() {
//         return Arrays.asList(new Object[][] {
//                 { "#dff0d8", "//div[@class='alert alert-success alert-normal-success']", "×\nI'm a normal success message. To close use the appropriate button.","Normal success message", "1" },
//                 { "#fcf8e3", "//div[@class='alert alert-warning alert-normal-warning']", "×\nI'm a normal warning message. To close use the appropriate button.", "Normal warning message", "2" },
//                 { "#f2dede", "//div[@class='alert alert-danger alert-normal-danger']", "×\nI'm a normal danger message. To close use the appropriate button.", "Normal danger message", "3" },
//                 { "#d9edf7", "//div[@class='alert alert-info alert-normal-info']", "×\nI'm a normal info message. To close use the appropriate button.", "Normal info message", "4" }
//         });
//     }





     //@ExtendWith


     public Collection data (){
         return new ArrayList(Collections.singleton(new Object[][]{
                 {properties.LOGIN_TEST1, properties.PASSWORD_TEST1},
                 {properties.LOGIN_TEST2, properties.PASSWORD_TEST3}
         }));
     }

@ParameterizedTest
@DisplayName("Ввод правильного логина и пароля с проверкой авторизации")
//@MethodSource("data")
@Attachment
//@CsvSource(value = {
//        "Тест, Т",
//        "Авто Пользователь, 1"
//})
@MethodSource("data")

     //@ArgumentsSource(MyArguments.class)
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




