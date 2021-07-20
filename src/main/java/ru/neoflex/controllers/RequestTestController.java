package ru.neoflex.controllers;
import io.restassured.http.ContentType;
import ru.neoflex.model.RequestSaveTestimony;

import static io.restassured.RestAssured.given;

public class RequestTestController {

    public static int getRequestCode(String uRL, RequestSaveTestimony requestSaveTestimony) {

        return given().
                contentType(ContentType.JSON).
                body(requestSaveTestimony).
                when().
                post(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }
}