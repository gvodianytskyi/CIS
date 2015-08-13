package com.sportsmen.api;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.response.Response;
import com.sportsmen.data.ApiTestData;
import org.junit.*;

public class ApiCreateTest {
    private Response response;
    private String cookieValue;

    private final String LOGIN_URL = "http://streamtv.net.ua/base/php/login.php";
    private final String CREATE_URL = "http://streamtv.net.ua/base/php/wrestler/create.php";
    private final String CREATE_JSON_PATH = "input/api/create_test.json";
    private final String CREDENTIALS_JSON = "{\"username\":\"auto\",\"password\":\"test\"}";
    private final String COOKIE_NAME = "PHPSESSID";
    private final String CONTENT_TYPE = "application/json";

    @Before
    public void login() {
        response = given()
                    .contentType(CONTENT_TYPE)
                    .body(CREDENTIALS_JSON).
                when().
                    post(LOGIN_URL);

        cookieValue = response.getCookie(COOKIE_NAME);
    }

    @Test
    public void createTest() {
        response = given()
                    .contentType(CONTENT_TYPE)
                    .body((new ApiTestData(CREATE_JSON_PATH)).getJSONString())
                    .cookie(COOKIE_NAME, cookieValue)
                .expect()
                    .statusCode(200)
                .when()
                    .post(CREATE_URL);
    }
}
