package com.restfulbooker.restfulbookerinfo;

import com.restfulbooker.model.RestfulBookerPojo;
import com.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class RestfulBookerPostTest extends TestBase {

    @Test
    public void createbooking() {
        HashMap<Object, Object> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");

        RestfulBookerPojo restfulBookerPojo = new RestfulBookerPojo();

        restfulBookerPojo.setFirstName("Jim");
        restfulBookerPojo.setLastName("Brown");
        restfulBookerPojo.setTotalprice("111");
        restfulBookerPojo.setDepositpaid("true");
        restfulBookerPojo.setBookingdates("dates");
        restfulBookerPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("adminn", "password123")
                .body(restfulBookerPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void bookingtoken(){

        RestfulBookerPojo restfulBookerPojo = new RestfulBookerPojo();

        restfulBookerPojo.setUsername("admin");
        restfulBookerPojo.setPassword("password123");
        Response response= given()
                .header("Content-Type","application/json")
                .body(restfulBookerPojo)
                .when()
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);


    }
}
