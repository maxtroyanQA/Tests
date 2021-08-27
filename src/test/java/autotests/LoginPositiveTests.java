package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;


public class LoginPositiveTests extends AuthorizedTestBase {

    @Test
    void PositiveTests() {
        foundSiteEdit(SITEEDIT)
                .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        NAME.shouldHave(Condition.attribute(properties.LOGIN));
        EMAIL.shouldHave(Condition.text(USEREMAIL));
    }
}
