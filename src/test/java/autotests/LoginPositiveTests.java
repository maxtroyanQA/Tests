package autotests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;


public class LoginPositiveTests extends AuthorizedTestBase {

    @Test
    void PositiveTests() {
        //Переход на сайт указанный в LoginPage->site
    //    open(site);
        //method chaining (цепочки вызовов)
      //      setLogin(userLogin)
       //         .setPass(userPassword)
       //         .buttonClick()
                foundSiteEdit(siteEdit)
                .clickUserAvatar();
        //сравнение введенного имени пользователя и пароля
        name.shouldHave(Condition.text(userLogin));
        email.shouldHave(Condition.text(userEmail));
        //получение месяца из даты системы (текущий месяц)
//        Calendar calendar = Calendar.getInstance();
//        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель",
//                                   "Май", "Июнь", "Июль", "Август",
//                              "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
//        };
//        String monthNow = monthNames[calendar.get(Calendar.MONTH)];
//
//   System.out.println(monthNow);


    }
}
