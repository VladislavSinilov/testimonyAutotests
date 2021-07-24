package ru.neoflex.controllers;
import io.restassured.http.ContentType;
import ru.neoflex.model.RequestChangePriceTestimony;
import ru.neoflex.model.RequestSaveTestimony;
import ru.neoflex.model.ResponseChangePriceTestimony;
import ru.neoflex.model.ResponseSaveTestimony;

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

    public static int getRequestCode(String uRL, RequestChangePriceTestimony requestChangePriceTestimony) {

        return given().
                contentType(ContentType.JSON).
                body(requestChangePriceTestimony).
                when().
                post(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }

    public static int getRequestCode(String uRL) {

        return given().
                get(uRL).
                then().
                extract().
                response().
                getStatusCode();
    }

    public static ResponseSaveTestimony getResponseBodySave(String uRL, RequestSaveTestimony requestSaveTestimony) {

        return  given().
                contentType(ContentType.JSON).
                body(requestSaveTestimony).
                when().
                post(uRL).
                then().
                extract().
                response().
                as(ResponseSaveTestimony.class);
    }

    public static ResponseChangePriceTestimony getResponseBodySave(String uRL, RequestChangePriceTestimony requestChangePriceTestimony) {

        return  given().
                contentType(ContentType.JSON).
                body(requestChangePriceTestimony).
                when().
                post(uRL).
                then().
                extract().
                response().
                as(ResponseChangePriceTestimony.class);
    }

    public static ResponseSaveTestimony getResponseBodySave(String uRL) {

        return given().
                get(uRL).
                then().
                extract().
                response().
                as(ResponseSaveTestimony.class);
    }
}