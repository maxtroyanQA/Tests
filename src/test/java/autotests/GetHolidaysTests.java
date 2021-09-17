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
import org.testng.asserts.SoftAssert;

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

        RestAssured.baseURI =properties.startSITE_P;
        RestAssured.port = properties.PORT_P;
        RestAssured.basePath = "/api/v2/public";

        //Общие параметры для всех запросов
        RequestSpecBuilder keyParameter = new RequestSpecBuilder();
        keyParameter.addParam("key", properties.KEY_P);
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

        SoftAssert soft = new SoftAssert();
        boolean holyDayFound = false;
        boolean shortDayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 2:
                    holyDayFound = true;
                    break;
                case 1:
                    shortDayFound = true;
                    break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item);
            }
        }
        apiPages.assertHolyShort(holyDayFound, shortDayFound);
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

        SoftAssert soft = new SoftAssert();
        boolean shortDayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 1:
                    shortDayFound = true;
                    break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item);
            }
        }
        apiPages.assertShort(shortDayFound);
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

        SoftAssert soft = new SoftAssert();
        boolean holyDayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 2:
                    holyDayFound = true;
                    break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item);
            }
        }
        apiPages.assertHoly(holyDayFound);
    }
}

