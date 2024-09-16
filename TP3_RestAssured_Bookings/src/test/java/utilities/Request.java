package utilities;

import constants.RestfulBookerEndpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Request {
    public static Response get(String endpoint) {
        RestAssured.baseURI = RestfulBookerEndpoint.BASE_URL;
        Response response = RestAssured.when().get(endpoint);
        response.then().log().body();
        return response;
    }

    public static Response getById(String endpoint, String id) {
        RestAssured.baseURI = RestfulBookerEndpoint.BASE_URL;
        Response response = RestAssured.given().pathParam("id", id).when().get(endpoint);
        response.then().log().body();
        return response;
    }

    public static Response post(String endpoint, String payload) {
        RestAssured.baseURI = RestfulBookerEndpoint.BASE_URL;
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .when().post(endpoint);
        response.then().log().body();
        return response;
    }
}

