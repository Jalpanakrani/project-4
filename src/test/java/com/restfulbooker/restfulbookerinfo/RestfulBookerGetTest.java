package com.restfulbooker.restfulbookerinfo;


import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class RestfulBookerGetTest extends TestBase {

    @Test
    public void getAllrestfulbookerInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSinglerestfulbookerInfo() {
        Response response = given()
                .pathParam("id", 1366)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
