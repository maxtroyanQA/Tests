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
//        Allure.addAttachment("My attachment", "My attachment content");
//
//        Path content = Paths.get("path-to-my-attachment-contnet");
//        try (InputStream is = Files.newInputStream(content)) {
//            Allure.addAttachment("My attachment", is);
//        }
//              System.out.println("testFailed");
//        Object instance = context.getRequiredTestInstance();
//WebDriver driver = WebDriverRunner.getWebDriver();
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("D:pageScreenshot.png"), true);


        //Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
       // ImageIO.write(screenshot.getImage(),"PNG",new Resource.File("path of the file"));

       // WebDriver driver =
      //          ((ThreadLocal<WebDriver>)instance.getClass().getDeclaredField("driver").get(instance)).get();

//        Allure.getLifecycle().addAttachment(
//                "Screenshot",
//                "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
//
//        );



      //  String pngFileName = screenshot("my_file_name");
//        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
//        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        //WebDriverRunner driver = new WebDriverRunner();
        //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        //FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot2.png"));
//        String path;
//        WebDriver driver =  new WebDriverRunner();
//        try {
//            WebDriver webDriver = new Augmenter().augment((WebDriver) driver);
//            File source = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//            path = "./target/screenshots/" + source.getName();
//            FileUtils.copyFile (source, new File(path));
//        }
//        catch(IOException e) {
//            path = "Failed to capture screenshot: " + e.getMessage();
//        }

        //WebDriver driver = (WebDriver) new WebDriverRunner();
       // Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)));
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        //FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
//        WebDriver driver = getDriver(context);
//
//        Allure.getLifecycle().addAttachment(
//                "Screenshot",
//                "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
//
//        );
//        closeWebDriver();
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
