package org.practice;

import io.qameta.allure.Step;

import java.net.URI;

import static io.restassured.RestAssured.*;


public class CourierClient extends RestAssuredClient{

    public final static String URI_PATH = "/api/v1/courier";

    @Step("Локин курьера")
    public static int loginCourier(CourierCrendentials courierCrendentials) {
        return given()
                .spec(getBaseSpec())
                .body(courierCrendentials)
                .when()
                .post(URI_PATH + "/login")
                .then()
                .assertThat().statusCode(200).extract().path("id");
    }

    @Step("Создание нового курьера")
    public static boolean createCourier(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(URI_PATH)
                .then().assertThat().statusCode(201).extract().path("ok");
    }

    @Step("Удаление курьера")
    public static boolean deleteCourier(int id) {
        return given()
                .spec(getBaseSpec())
                .when()
                .delete(URI_PATH + "/" + id)
                .then()
                .assertThat().statusCode(200).extract().path("ok");
    }
}
