package autotests;

import com.codeborne.selenide.testng.ScreenShooter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
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
public class GetHolidaysTests extends TestBase{


    @BeforeClass
    public void setupAPI() {
        RestAssured.baseURI = "https://tt-develop.quality-lab.ru";
        RestAssured.port = 443;
        RestAssured.basePath = "/api/v2/public";

//        //Общие параметры для всех запросов
        RequestSpecBuilder keyParameter = new RequestSpecBuilder();
        keyParameter.addParam("key", "wvS9fmlcgT6jOIO6tyhESV55F6dbNpk3PeWkobf8");
        RestAssured.requestSpecification = keyParameter.build();

//        //Общие проверки для всех ответов
        ResponseSpecBuilder responseValidations = new ResponseSpecBuilder();
        responseValidations.expectStatusCode(200);
        responseValidations.expectBody("response.messages.type",
                Matchers.not(Matchers.hasItem("error")));
        RestAssured.responseSpecification = responseValidations.build();
    }


    @Test(description = "Тест API (без параметров)")
    public void WithoutParametersTest() {
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
    public void ParameterYear() {

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
        boolean shortSayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 2:
                    holyDayFound = true; break;
                case 1:
                    shortSayFound = true; break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item.toString());
            }
        }
        soft.assertTrue(holyDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertTrue(shortSayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertAll();
    }

    @Test(description = "Тест API (параметр: тип дня (короткий день))")
    public void ParameterDataTypeShortDay() {
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
        boolean holyDayFound = false;
        boolean shortSayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 1:
                    shortSayFound = true; break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item.toString());
            }
        }
        soft.assertFalse(holyDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertTrue(shortSayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertAll();
    }

    @Test(description = "Тест API (параметр: тип дня (выходной день))")
    public void ParameterDataTypeHolyDay() {
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
        boolean shortSayFound = false;
        for (HolidayItem item :
                items) {

            switch (item.type_id) {
                case 2:
                    holyDayFound = true; break;
                default:
                    soft.fail("Обнаружен день неизвестного типа: " +
                            item.toString());
            }
        }
        soft.assertTrue(holyDayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertFalse(shortSayFound,
                "не найдено ни одного дня с типом HOLY_DAY");
        soft.assertAll();
    }
}

class HolidayItem {

    protected int type_id;
    private String type;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

}

