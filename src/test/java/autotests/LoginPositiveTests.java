package autotests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginPositiveTests extends LoginPage {
    @Test
    void PositiveTests(){
        try {
            driver.get(Site);
            WebElement element;
            driver.manage().window().maximize();

            XpathUser.click();
            XpathUser.sendKeys(Login);

            XpathPass.click();
            XpathPass.sendKeys(Password);

            XpathButton.click();

            assertEquals(driver.getCurrentUrl(), SiteEdit);

            XpathAvatar.click();

            String getUserName = XpathLoginName.getText();
            assertEquals(getUserName, Login);

            String getEmail = XpathEmail.getText();
            assertEquals(getEmail, Email);
        }
        catch (NoSuchElementException ignored){
            assertThrows(NoSuchElementException.class, () ->{
                WebElement element = driver.findElement(By.xpath(FoundText));
            });
        }
    }
}
