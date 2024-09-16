package stepDefinitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.RestfulBookerEndpoint;
import entities.Booking;
import entities.BookingDates;
import entities.InvalidBooking;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utilities.Request;

import java.util.List;

public class BookingSteps {

    Response response;
    String payload;

    @Given("I have the following data to create a new booking")
    public void buildValidPayload(DataTable bookingInformation) throws JsonProcessingException {
        List<String> data = bookingInformation.transpose().asList(String.class);
        BookingDates bookingDates = new BookingDates();

        if (data.get(0) != null) {
            bookingDates.setCheckin(data.get(0));
        }

        if (data.get(1) != null) {
            bookingDates.setCheckout(data.get(1));
        }

        Booking booking = new Booking();

        if (data.get(2) != null) {
            booking.setFirstname(data.get(2));
        }

        if (data.get(3) != null) {
            booking.setLastname(data.get(3));
        }

        if (data.get(4) != null) {
            booking.setDepositpaid(Boolean.parseBoolean(data.get(4)));
        }

        if (data.get(5) != null) {
            booking.setTotalprice(Integer.parseInt(data.get(5)));
        }

        if (data.get(6) != null) {
            booking.setAdditionalneeds(data.get(6));
        }

        booking.setBookingdates(bookingDates);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        payload = mapper.writeValueAsString(booking);
    }


    @When("I send a POST request to the booking endpoint with the payload")
    public void postBooking() {
        response = Request.post(RestfulBookerEndpoint.POST_BOOKING, payload);
    }

    @Then("I should get a {int} response")
    public void verifyStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Given("I have the following data to create a new booking with invalid data types")
    public void buildInvalidPayload(DataTable bookingInformation) throws JsonProcessingException {
        List<String> data = bookingInformation.transpose().asList(String.class);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(data.get(0));
        bookingDates.setCheckout(data.get(1));

        InvalidBooking booking = new InvalidBooking();
        booking.setFirstname(data.get(2));
        booking.setLastname(data.get(3));
        booking.setDepositpaid(Integer.parseInt(data.get(4)));
        booking.setTotalprice(Boolean.parseBoolean(data.get(5)));
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(data.get(6));

        ObjectMapper mapper = new ObjectMapper();

        payload = mapper.writeValueAsString(booking);
    }

    @Given("I send a GET request to the booking endpoint with the id {string}")
    public void getBookingById(String id) {
       response = Request.getById(RestfulBookerEndpoint.GET_BOOKING, id);
    }

    @And("The response should contain all booking fields")
    public void verifyGetBookingByIdResponseContent(){
        response.then().assertThat().body("$", Matchers.hasKey("firstname"));
        response.then().assertThat().body("$", Matchers.hasKey("lastname"));
        response.then().assertThat().body("$", Matchers.hasKey("totalprice"));
        response.then().assertThat().body("$", Matchers.hasKey("depositpaid"));
        response.then().assertThat().body("$", Matchers.hasKey("bookingdates"));
        response.then().assertThat().body("bookingdates", Matchers.hasKey("checkin"));
        response.then().assertThat().body("bookingdates", Matchers.hasKey("checkout"));
    }
}
