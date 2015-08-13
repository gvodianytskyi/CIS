package com.sportsmen.api;

import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class ApiDeleteTest {
    private Response response;
    private String cookieValue;

    private final String LOGIN_URL = "http://streamtv.net.ua/base/php/login.php";
    private final String DELETE_URL = "http://streamtv.net.ua/base/php/wrestler/delete.php?id=";
    private final String ID = "1098";
    private final String CREDENTIALS_JSON = "{\"username\":\"auto\",\"password\":\"test\"}";
    private final String COOKIE_NAME = "PHPSESSID";
    private final String CONTENT_TYPE = "application/json";

    @Before
    public void login() {
        response = given()
                .contentType(CONTENT_TYPE).
                        body(CREDENTIALS_JSON).
                        when().
                        post(LOGIN_URL);

        cookieValue = response.getCookie(COOKIE_NAME);
    }

    @Test
    public void deleteTest() {
        response = given().
                contentType(CONTENT_TYPE)
                .cookie(COOKIE_NAME, cookieValue)
                .expect()
                .statusCode(200)
                .when()
                .post(DELETE_URL + ID);

        try {
            JSONAssert.assertEquals("{\"result\":true}", response.asString(), true);
        } catch (AssertionError ae) {
            fail("Was not deleted.");
        }
    }
}
