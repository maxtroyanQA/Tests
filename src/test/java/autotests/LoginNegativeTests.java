package autotests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LoginNegativeTests extends LoginPage {

    @Test
    void incorrectUserNameAndPassword(){
        try {
            driver.get(Site);
            WebElement element;


            XpathButton.click();

            element = driver.findElement(By.xpath(FoundText));
            fail();

            assertEquals(driver.getCurrentUrl(), SiteLogin);
        }
        catch (NoSuchElementException ignored){
            assertThrows(NoSuchElementException.class, () ->{
                WebElement element = driver.findElement(By.xpath(FoundText));
            });
        }
    }
}
