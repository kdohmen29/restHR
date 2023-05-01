package com.astontech.resthr;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class MakeApiTestRestAssured {

    @Test
    public void testEndpointShouldReturn200() {
        get("/test")
                .then()
                .statusCode(200);
    }


    @Test
    public void whenUsePathParamValidId_thenOK() {
        given().pathParam("id", 1)
                .when().get("/make/{id}")
                .then().statusCode(200);
    }

    @Test
    public void whenUsePathParamInvalidId_thenNot_Found() {
        given().pathParam("id", 9999)
                .when().get("/make/{id}")
                .then().statusCode(404);
    }

    @Test
    public void whenUseQueryParamValidMakeName_thenOK() {
        given().queryParam("makeName", "Jeep")
                .when().get("/make")
                .then().statusCode(200);
    }

    @Test
    public void whenFindByMakeNameAssertMakeId() {
        given().queryParam("makeName", "Jeep")
                .when().get("/make")
                .then().statusCode(200)
                .assertThat()
                .body("id", equalTo(1));
    }

    @Test
    public void getResponseTime() {
        System.out.println("Response time: " + get("/make/").timeIn(TimeUnit.MILLISECONDS) + " ms");
    }

    @Test
    public void getResponseContentType() {
        System.out.println("Content Type of response: " + get("/make/").then().extract().contentType());
    }

    @Test
    public void saveMakeShouldReturnAnID() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("makeName", "Chevy");

        given().header("content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post("/make/")
                .then().statusCode(201)
                .assertThat()
                .body("$", hasKey("id"))
                .body("makeName", equalTo("Chevy"));

    }
}
