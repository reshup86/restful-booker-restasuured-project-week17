package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PostBookingTest extends TestBase {

    @Test
    public void createNewBooking() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2023-01-01");
        bookingdates.put("checkout", "2023-01-05");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Rosy");
        bookingPojo.setLastname("Gill");
        bookingPojo.setTotalPrice(300);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingDates(bookingdates);
        bookingPojo.setAdditionalNeeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer d235d8fe8e2001308dc4860ffd7a004a969e0b94a8680259cf66e639f3cb687b")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}