package autotests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class LoginPositiveTests extends TestBase {
    TypesProperties properties = new TypesProperties();
    @Test
    void PositiveTests() throws Exception {
        authorized.Authorized();

        loginPage.foundSiteEdit(loginPage.SITEEDIT)
                 .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        loginPage.NAME.shouldHave(Condition.text(properties.LOGIN_P));
        loginPage.EMAIL.shouldHave(Condition.text(loginPage.USEREMAIL));
    }

}
