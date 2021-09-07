package autotests;


import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetHolidaysTests {

    @BeforeClass
    public  void setupAPI() {
//        RestAssured.baseURI = "https://tt-develop.quality-lab.ru";
//        RestAssured.port = 443;
//        RestAssured.basePath = "/api/v2/public";

//        //Общие параметры для всех запросов
//        RequestSpecBuilder keyParameter = new RequestSpecBuilder();
//        keyParameter.addParam("key", "wvS9fmlcgT6jOIO6tyhESV55F6dbNpk3PeWkobf8");
//        RestAssured.requestSpecification = keyParameter.build();
//
//        //Общие проверки для всех ответов
//        ResponseSpecBuilder responseValidations = new ResponseSpecBuilder();
//        responseValidations.expectStatusCode(200);
//        responseValidations.expectBody("response.messages.type", Matchers.not(Matchers.hasItem("error")));
//        RestAssured.responseSpecification = responseValidations.build();
    }


    @Test
    public void GetHolidays() {
        //    RequestSpecification requestSpec = new RequestSpecBuilder().addParam("key", "wvS9fmlcgT6jOIO6tyhESV55F6dbNpk3PeWkobf8").build();
           // ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();

        given()
                .contentType(ContentType.JSON)
                .baseUri("https://tt-develop.quality-lab.ru")
                .basePath("/api/v2/public")
                .port(443)
                .param("key", "wvS9fmlcgT6jOIO6tyhESV55F6dbNpk3PeWkobf8")
                .when()
                .get("/Calendar/GetToday")
                .then()
                //.spec(responseSpec)
                .body("response.messages.type", Matchers.not(Matchers.hasItem("error")));
    }
}
