package autotests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;

public class ScreenshotExtension implements TestWatcher {


    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String pngFileName = screenshot("my_file_name");
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
