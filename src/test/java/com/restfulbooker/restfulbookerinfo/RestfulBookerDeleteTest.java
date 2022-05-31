package com.restfulbooker.restfulbookerinfo;

import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class RestfulBookerDeleteTest extends TestBase {

    @Test
    public void deleteuser(){
        Response response=given()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","password123")
                .pathParam("id", 1509)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        System.out.println("Data is delated");
        response.prettyPrint();
    }

}
