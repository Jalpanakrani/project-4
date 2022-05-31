package com.restfulbooker.restfulbookerinfo;


import com.restfulbooker.model.RestfulBookerPojo;
import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class RestfulBookingPatchTest extends TestBase {

    @Test
    public void updaterestfulbookerWithPatch(){
        HashMap<Object,Object> dates =new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        RestfulBookerPojo restfulBookerPojo = new RestfulBookerPojo();

        restfulBookerPojo.setFirstName("Jim");
        restfulBookerPojo.setLastName("Brown");
        restfulBookerPojo.setTotalprice("121");
        restfulBookerPojo.setDepositpaid("true");
        restfulBookerPojo.setBookingdates("dates");
        restfulBookerPojo.setAdditionalneeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","password123")
                .pathParam("id","1509")
                .body(restfulBookerPojo)
                .when()
                .patch("/booking/{id)");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
