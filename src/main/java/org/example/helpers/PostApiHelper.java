package org.example.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ConfigProvider;
import org.example.models.Post;

public class PostApiHelper {

    private static RequestSpecification createRequest() {
        return RestAssured.given()
                .baseUri(ConfigProvider.getBaseUrl())
                .header("Content-Type", "application/json")
                .log().all();
    }

    public static Response getPostById(int idPost) {
        return createRequest()
                .get("/posts/" + idPost)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static Response createPost(Post post) {
        return createRequest()
                .body(post)
                .post("/posts/")
                .then()
                .statusCode(201)
                .extract()
                .response();
    }

    public static Response updatePost(int id, Post post) {
        return createRequest()
                .body(post)
                .put("/posts/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }


    public static Response deletePost(int id) {
        return createRequest()
                .delete("/posts/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}