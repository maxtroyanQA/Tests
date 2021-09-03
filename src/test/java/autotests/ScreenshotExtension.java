package autotests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class ScreenshotExtension implements TestWatcher {


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

//        String RANDOM_FAIL = String.valueOf(new Random()
//                .ints(1, 1, 2000000000).findFirst().getAsInt());
//      screenshot(RANDOM_FAIL);
        closeWebDriver();

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

        closeWebDriver();

    }

    @Override
    public void testSuccessful(ExtensionContext context) {

        closeWebDriver();

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

        closeWebDriver();

    }
}
