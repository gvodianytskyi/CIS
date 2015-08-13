package com.sportsmen.api;

import com.jayway.restassured.response.Response;
import com.sportsmen.data.ApiTestData;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class ApiUpdateTest {
    private Response response;
    private String cookieValue;

    private final String LOGIN_URL = "http://streamtv.net.ua/base/php/login.php";
    private final String UPDATE_URL = "http://streamtv.net.ua/base/php/wrestler/update.php";
    private final String UPDATE_JSON_PATH = "input/api/update_test.json";
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
    public void updateTest() {
        response = given()
                .contentType(CONTENT_TYPE)
                .body((new ApiTestData(UPDATE_JSON_PATH)).getJSONString())
                .cookie(COOKIE_NAME, cookieValue)
            .expect()
                .statusCode(200)
            .when()
                .post(UPDATE_URL);

        System.out.println(response.asString());
        try {
            JSONAssert.assertEquals("{\"result\":true}", response.asString(), true);
        } catch (AssertionError ae) {
            fail("Was not updated.");
        }
    }
}
