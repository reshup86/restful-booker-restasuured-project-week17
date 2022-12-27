package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {
    @Test
    public void verifyUserDeleteSuccessfully() {
        Response response = given()
                .header("Authorization", "Bearer d235d8fe8e2001308dc4860ffd7a004a969e0b94a8680259cf66e639f3cb687b")
                .header("Content-Type", "application/json")
                .pathParam("id", 45)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
