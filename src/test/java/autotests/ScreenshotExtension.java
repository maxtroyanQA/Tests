package autotests;

import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.Optional;

public class ScreenshotExtension implements TestWatcher {

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = getDriver(context);
        System.out.println("testFailed");
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("testDisabled");
        getDriver(context).close();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("testSuccessful");
        getDriver(context).close();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("testAborted");
        getDriver(context).close();

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
