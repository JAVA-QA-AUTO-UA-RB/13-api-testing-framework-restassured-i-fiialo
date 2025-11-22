package org.example.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ConfigProvider;

public class UserApiHelper {

    private static RequestSpecification createRequest() {
        return RestAssured.given()
                .baseUri(ConfigProvider.getBaseUrl())
                .header("Content-Type", "application/json")
                .log().all();
    }

    public static Response getUserById(int userId) {
        return createRequest()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static Response getUserByUsername(String username) {
        return createRequest()
                .get("/users?username=" + username)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}