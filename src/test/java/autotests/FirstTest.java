package autotests;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstTest {
    @BeforeAll
    static void first (){

        System.out.println ("login.FirstTest class started");
    }
    @BeforeEach
    void start(){

        System.out.println ("Test start");
    }
    @Test
    void myTest (){
        assertTrue(1/0==1);
        System.out.println ("My first autotest running");

    }
    @Test
    void test1 (){
        assertEquals(2+2, 4);
        System.out.println ("Test №1");
    }
    @Test
    void test2 (){
        assertEquals(2+2, 5);
        System.out.println ("Test №2");
    }
    @Test
    void test3 (){
        assertTrue(2+2==4);
        System.out.println ("Test №3");
    }
    @Test
    void test4 (){
        assertTrue(2+2==5);
        System.out.println ("Test №4");
    }
    @Test
    void test5 (){
        assertEquals(2+2, 4);
        assertEquals(2+2, 5);
        assertTrue(2+2==4);
        assertTrue(2+2==5);
        System.out.println ("Test №5");
    }
    @AfterEach
    void finished() {
        System.out.println("Test finished");
    }
    @AfterAll
    static void last (){
        System.out.println("All tests in login.FirstTest finished");
    }
}

class LoginTest extends TestBase {
    @Test
    void incorrectUserNameAndPassword(){
     /*   driver = new ChromeDriver(new ChromeOptions().addArguments("--window-size=600,600"));
        driver.get("https://tt-develop.quality-lab.ru");
        WebElement element;
        element = driver.findElement(By.xpath("//input[@name='_username']"));
        element.click();
        element.sendKeys("TestUser");
        element = driver.findElement(By.xpath("//input[@id='password']"));
        element.click();
        element.sendKeys("Password");
        element = driver.findElement(By.xpath("//input[@id='_submit']"));
        element.click();
     */   try {
           // element = driver.findElement(By.xpath("// div [text()='Invalid credentials.']"));
            //div[div='Invalid credentials.']
            //div[@class='m-login__signin']/div[1]
         //   fail();
        }
        catch (NoSuchElementException ignored){


        }
    }
}
