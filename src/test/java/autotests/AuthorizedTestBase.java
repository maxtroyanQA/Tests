package autotests;

import com.codeborne.selenide.WebDriverRunner;
import okhttp3.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;


public class AuthorizedTestBase extends TestBase{

    @BeforeMethod
    //@Factory(dataProvider = "loader user")
    @Parameters({"login", "pass"})
    public void authorizedCookie(String login, String pass) throws IOException {

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        JavaNetCookieJar cookieJar = new JavaNetCookieJar(cookieManager);

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .followRedirects(false)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("_csrf_token", "")
                .add("_username", login)
                .add("_password", pass)
                .add("_submit", "Войти")
                .build();

        Request request = new Request.Builder()
                .url(loginPage.SITE + "/login_check")
                .addHeader("cookie", loginPage.COOKIE)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        open(loginPage.SITE + "/login");

        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().deleteAllCookies();

        cookieManager.getCookieStore().getCookies().forEach(httpCookie -> {
            org.openqa.selenium.Cookie cookie = new Cookie(
                    httpCookie.getName(),
                    httpCookie.getValue(),
                    httpCookie.getDomain(),
                    httpCookie.getPath(), null
            );
            driver.manage()
                    .addCookie(cookie);
        });

        open(loginPage.SITE + "/calendar");
    }
    @DataProvider(name = "loader user")
    public static Object[][] createData() {

        return new Object[][] {{"Авто Пользователь", "12345678"},
               // {"Авто Пользователь2","2"}
        };
    }
}
