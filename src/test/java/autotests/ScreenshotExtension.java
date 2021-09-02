package autotests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class ScreenshotExtension implements TestWatcher {


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)));

//        WebDriver driver = getDriver(context);
//        System.out.println("testFailed");
//        Allure.getLifecycle().addAttachment(
//                "Screenshot",
//                "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
//        );
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        closeWebDriver();
        //getDriver(context).close();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        closeWebDriver();
        //getDriver(context).close();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        closeWebDriver();
        //getDriver(context).close();

    }

    private WebDriver getDriver(ExtensionContext context) {
        Object instance = context.getTestInstance();
        try {
            Field field = instance.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            return ((ThreadLocal<WebDriver>) field.get(instance)).get();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
