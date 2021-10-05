package assistive;

public class DataProvider {

    @org.testng.annotations.DataProvider(parallel = true, name = "dataWrongUser")
    public Object[][] dataProviderMethod() {

        return new Object[][]{
                {"TestUser", "Password"}
        };
    }
}
