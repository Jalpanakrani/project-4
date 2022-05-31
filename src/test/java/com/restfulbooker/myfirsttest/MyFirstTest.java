package com.restfulbooker.myfirsttest;

import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

/**
 * Created by Jay Vaghani
 */
public class MyFirstTest extends TestBase {

    @Test
    public void getAllStudentInfo() {
      /*  given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200);*/
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
