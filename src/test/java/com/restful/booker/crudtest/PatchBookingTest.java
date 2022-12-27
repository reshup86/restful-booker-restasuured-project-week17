package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {
    @Test
    public void updateBookingById() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Abc");
        bookingPojo.setLastname("xyz");
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositPaid(false);
        bookingPojo.setBookingDates(bookingdates);
        bookingPojo.setAdditionalNeeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer d235d8fe8e2001308dc4860ffd7a004a969e0b94a8680259cf66e639f3cb687b")
                .pathParam("id", 100)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
