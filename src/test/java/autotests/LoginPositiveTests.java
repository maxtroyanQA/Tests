package autotests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;


public class LoginPositiveTests extends LoginPage {

    @Test
    void PositiveTests() {
        //Установка браузера открытия
        // браузер default Chrome
        Configuration.browser = "chrome";
        //Установка размер окра браузера
        Configuration.browserSize = "1500x1500";
        //Переход на сайт указанный в LoginPage->site
        Selenide.open(site);
        //method chaining (цепочки вызовов)
            setLogin(userLogin)
                .setPass(userPassword)
                .buttonClick()
                .foundSiteEdit(siteEdit)
                .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        name.shouldHave(Condition.text(userLogin));
        email.shouldHave(Condition.text(userEmail));


    }
}
