package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;


public class LoginPositiveTests extends LoginPage {

    @Test
    void PositiveTests(){
        try {
            //Установка браузера открытия
            // браузер default Chrome
            Configuration.browser = "chrome";
            //Установка размер окра браузера
            Configuration.browserSize = "1500x1500";
            //Переход на сайт указанный в LoginPage->site
            Selenide.open(site);
            //method chaining (цепочки вызовов)
            setLogin()
                    .setPass()
                    .buttonClick()
                    .clickUserAvatar();
            //button.shouldBe(visible.because("Кнопка должна быть видимой")).click();
           // ((SelenideElement)this.enter.getWrappedElement()).shouldBe(Condition.visible).click();
            /* driver.get(Site);
            WebElement element;
            driver.manage().window().maximize();

            XpathUser.click();
            XpathUser.sendKeys(Login);

            XpathPass.click();
            XpathPass.sendKeys(Password);

            XpathButton.click();

            assertEquals(driver.getCurrentUrl(), SiteEdit);

            XpathAvatar.click();


           */
//            String getUserName = XpathLoginName.getText();
//            assertEquals(getUserName, Login);
//
//            String getEmail = XpathEmail.getText();
//            assertEquals(getEmail, Email);
       System.out.println("OK");
        }
        catch (NoSuchElementException ignored){
           // assertThrows(NoSuchElementException.class, () ->{
           //     WebElement element = driver.findElement(By.xpath(FoundText));
           // });
        }


    }



   }
















//        public setLogin setLogin (login) {
//
//            return this;
//        }
//
//        public setLogin setLogin(String userLogin) {
//            return this;
//        }
//
//        public setLogin setPassword(String userPassword) {
//
//
//        }


