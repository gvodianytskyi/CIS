package com.sportsmen.api;

import com.jayway.restassured.response.Response;
import com.sportsmen.data.ApiTestData;
import org.junit.*;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ApiReadTest {
    private Response response;
    private String cookieValue;

    private final String LOGIN_URL = "http://streamtv.net.ua/base/php/login.php";
    private final String READ_URL = "http://streamtv.net.ua/base/php/wrestler/read.php?id=";
    private final String ID = "985";
    private final String READ_JSON_PATH = "input/api/read_test.json";
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
    public void readTest() {
        response = given().
                    contentType(CONTENT_TYPE)
                    .cookie(COOKIE_NAME, cookieValue)
                .expect()
                    .statusCode(200)
                .when()
                    .get(READ_URL + ID);

        ApiTestData data = new ApiTestData(READ_JSON_PATH);

        try {
            JSONAssert.assertEquals(data.getJSONString(), response.asString(), true);
        } catch (AssertionError ae) {
            fail("Not equal.");
        }
    }
}
