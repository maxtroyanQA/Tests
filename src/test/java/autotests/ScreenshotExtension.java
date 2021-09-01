package autotests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class ScreenshotExtension implements TestWatcher {


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Ypal");
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

//    private WebDriver getDriver(ExtensionContext context) {
//        Object instance = context.getTestInstance();
//        try {
//            Field field = instance.getClass().getDeclaredField("driver");
//            field.setAccessible(true);
//            return ((ThreadLocal<WebDriver>) field.get(instance)).get();
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
