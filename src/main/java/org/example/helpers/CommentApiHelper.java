package org.example.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ConfigProvider;

public class CommentApiHelper {

    private static RequestSpecification createRequest() {
        return RestAssured.given()
                .baseUri(ConfigProvider.getBaseUrl())
                .header("Content-Type", "application/json")
                .log().all();
    }

    public static Response getCommentById(int commentId) {
        return createRequest()
                .get("/comments/" + commentId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static Response getCommentsByPostId(int postId) {
        return createRequest()
                .get("/comments?postId=" + postId)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}