package autotests;

import assistive.HolidayItem;
import assistive.TestBase;
import com.codeborne.selenide.testng.ScreenShooter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.startsWith;

@Listeners({ScreenShooter.class})
public class GetHolidaysTests extends TestBase {


    @BeforeMethod
    public void setupAPI() {

        RestAssured.baseURI = properties.startSITE;
        RestAssured.port = properties.PORT;
        RestAssured.basePath = "/api/v2/public";

        //Общие параметры для всех запросов
        RequestSpecBuilder keyParameter = new RequestSpecBuilder();
        keyParameter.addParam("key", properties.KEY);
        RestAssured.requestSpecification = keyParameter.build();

        //Общие проверки для всех ответов
        ResponseSpecBuilder responseValidations = new ResponseSpecBuilder();
        responseValidations.expectStatusCode(200);
        responseValidations.expectBody("response.messages.type",
                Matchers.not(Matchers.hasItem("error")));
        RestAssured.responseSpecification = responseValidations.build();
    }


    @Test(description = "Тест API (без параметров)")
    public void withoutParametersTest() {
        JsonPath jsonPath = JsonPath.given(given()
                .when()
                .get("/Calendar/GetHolidays")
                .then()
                .spec(responseSpecification)
                .body("response.items.date",
                        everyItem(startsWith(LocalDate.now().
                                format(DateTimeFormatter.ofPattern("yyyy")))))
                .extract()
                .body().jsonPath()
                .prettyPrint());
    }

    @Test(description = "Тест API (параметр: год (2019))")
    public void parameterYear() {

        JsonPath jsonPath = JsonPath.given(given()
                .param("year", "2019")
                .spec(requestSpecification)
                .when()
                .get("/Calendar/GetHolidays")
                .then()
                .spec(responseSpecification)
                .body("response.items.date", everyItem(startsWith("2019")))
                .extract()
                .body().jsonPath()
                .prettyPrint());

        List<HolidayItem> items =
                jsonPath.getList("response.items", HolidayItem.class);

        apiPages.assertAll(items);
    }

    @Test(description = "Тест API (параметр: тип дня (короткий день))")
    public void parameterDataTypeShortDay() {
        JsonPath jsonPath = JsonPath.given(given()
                .param("day_type", "SHORT_DAY")
                .spec(requestSpecification)
                .when()
                .get("/Calendar/GetHolidays")
                .then()
                .spec(responseSpecification)
                .body("response.items.type", everyItem(startsWith("short_day")))
                .extract()
                .body().jsonPath()
                .prettyPrint());
        List<HolidayItem> items =
                jsonPath.getList("response.items", HolidayItem.class);

        apiPages.assertShort(items);
    }

    @Test(description = "Тест API (параметр: тип дня (выходной день))")
    public void parameterDataTypeHolyDay() {
        JsonPath jsonPath = JsonPath.given(given()
                .param("day_type", "HOLY_DAY")
                .spec(requestSpecification)
                .when()
                .get("/Calendar/GetHolidays")
                .then()
                .spec(responseSpecification)
                .body("response.items.type", everyItem(startsWith("holy_day")))
                .extract()
                .body().jsonPath()
                .prettyPrint());
        List<HolidayItem> items =
                jsonPath.getList("response.items", HolidayItem.class);

        apiPages.assertHoly(items);
    }
}

