package assistive;

import com.codeborne.selenide.WebDriverRunner;
import okhttp3.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizedTestBase extends TestBase {


    /**
     * Авторизация с помощью ввода логина и пароля
     */
    public void authorizedLogPass() {

        open(properties.startSITE);

        loginPage.setLogin(properties.LOGIN)
                .setPass(properties.PASSWORD)
                .clickButton();
    }

    /**
     * Авторизация через куки
     */
    public void authorizedCookie() throws IOException {

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
                .add("_username", properties.LOGIN)
                .add("_password", properties.PASSWORD)
                .add("_submit", "Войти")
                .build();

        Request request = new Request.Builder()
                .url(properties.startSITE + "/login_check")
                .addHeader("cookie", properties.COOKIE)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        assertThat(response.code(), equalTo(302));

        open(properties.startSITE + "/login");

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
    }
}


