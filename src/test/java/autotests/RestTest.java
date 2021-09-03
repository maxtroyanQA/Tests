package autotests;

import com.codeborne.selenide.WebDriverRunner;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RestTest extends TestBase {

    @Test
    public void cookie() throws IOException {

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        JavaNetCookieJar cookieJar = new JavaNetCookieJar(cookieManager);

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .followRedirects(false)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("_csrf_token", "")
                .add("_username", "Авто Пользователь")
                .add("_password", "12345678")
                .add("_submit", "Войти")
                .build();

        Request request = new Request.Builder()
                .url("https://tt-develop.quality-lab.ru/")
                .addHeader("cookie", "PHPSESSID=5416dfb20f97f250dc8ed6d9d03a6d8e")
                .addHeader("path", "/login_check")
                .post(formBody)
                .build();


        Call call = client.newCall(request);

        Response response = call.execute();
       // assertThat(call.execute().code(), equalTo(200));

        open(loginPage.SITE);

        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().deleteAllCookies();

        cookieManager.getCookieStore().getCookies().forEach(httpCookie -> {
            Cookie cookie = new Cookie(
                    httpCookie.getName(),
                    httpCookie.getValue(),
                    httpCookie.getDomain(),
                    httpCookie.getPath(), null
            );
            driver.manage()
                    .addCookie(cookie);
        });

        open(loginPage.SITECALENDAR);
        sleep(10000);
    }


}
