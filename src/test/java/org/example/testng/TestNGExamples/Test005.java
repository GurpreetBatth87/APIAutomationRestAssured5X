package org.example.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test005 {
    String token;

    Integer BookingId;

    ValidatableResponse validatsblerespon;
    RequestSpecification requestSpecification;

    @BeforeTest
    public void gettiken(){
        System.out.println("--get Token -");
        requestSpecification  = RestAssured.given();

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);

        //Making Req

        Response res = requestSpecification.post();


        // validation part

        validatsblerespon =res.then();

        //Rest Assured -- > Matches(Hamcrest)-- 1-2% Times you will be using it
        validatsblerespon.body("token", Matchers.notNullValue());

        //TestNG assertion
        token = res.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
    }
    @BeforeTest
    public void getbookingID(){
        System.out.println("--get Booking -ID");
        requestSpecification  = RestAssured.given();

        String payload = "{\n" +
                "    \"firstname\" : \"Pramod@123\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 100,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-02-01\",\n" +
                "        \"checkout\" : \"2024-02-11\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"breakfast\", \"lunch\"]\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);

        //Making Req

        Response res = requestSpecification.when().post();


        // validation part

        ValidatableResponse validatsblerespon =res.then();
        String responseString = res.asString();
        System.out.println(responseString);
        validatsblerespon.statusCode(200);
        BookingId = res.then().log().all().extract().path("bookingid");
        Assert.assertNotNull(BookingId);
        System.out.println(BookingId);


    }
    @Test
    public void testPUTRequest(){
        System.out.println("________Test case PUT Request___");
        String payload ="{\n" +
                "    \"firstname\" : \"Gurpreet1\",\n" +
                "    \"lastname\" : \"Batth\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+BookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload).log().all();

        //calling PUT methos on URI After hitting we get responsr

        Response Response = requestSpecification.when().put();


        //Get validate response to perfortm validation
        validatsblerespon = Response.then().log().all();
        validatsblerespon.statusCode(200);
        validatsblerespon.body("firstname", Matchers.equalTo("Gurpreet1"));
        validatsblerespon.body("lastname", Matchers.equalTo("Batth"));

    }

    @Test
    public void testPUTRequest2(){
        System.out.println("________Test case PUT Request___");
        String payload ="{\n" +
                "    \"firstname\" : \"Gurpreet1\",\n" +
                "    \"lastname\" : \"Batth\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+BookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload).log().all();

        //calling PUT methos on URI After hitting we get responsr

        Response Response = requestSpecification.when().put();


        //Get validate response to perfortm validation
        validatsblerespon = Response.then().log().all();
        validatsblerespon.statusCode(200);

        String firstname = Response.then().log().all().extract().path("firstname");
        Assert.assertNotNull(token);

        //Asseert J
        assertThat(firstname).isNotNull().isNotBlank().isNotEmpty();
        System.out.println(token);

    }
}


