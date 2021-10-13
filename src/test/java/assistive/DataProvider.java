package assistive;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "dataProviderBrowserDocker")
    public Object[][] dataProviderDocker() {

        return new Object[][]{
                {"docker_opera"}, {"docker_chrome"}, {"docker_firefox"}
        };
    }

    @org.testng.annotations.DataProvider(name = "dataProviderBrowser")
    public Object[][] dataProviderBrowser() {

        return new Object[][]{
                {"Opera"}, {"Chrome"}, {"Firefox"}
        };
    }
}
