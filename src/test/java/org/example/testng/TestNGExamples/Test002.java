package org.example.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Test002 {
    //PUT Request
    //Before - token , ID
    ValidatableResponse validatsblerespon;
    RequestSpecification requestSpecification;
    String token;

    @BeforeTest
    public void gettoken(){
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

        //Asseert J
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
        System.out.println(token);
//        String responseString = res.asString();
//        System.out.println(responseString);
//        validatsblerespon.statusCode(200);

    }
@Test
    public void testNOnBDDStyylePUTReq(){
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
//        String payload2 ="{\n" +
//                "    \"firstname\" : \"Gurpreet\",\n" +
//                "    \"lastname\" : \"Manpreet\"\n" +
//                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/130");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload).log().all();

        //calling PUT methos on URI After hitting we get responsr

        Response Response = requestSpecification.when().patch();


        //Get validate response to perfortm validation
        validatsblerespon = Response.then().log().all();
        validatsblerespon.statusCode(200);
        validatsblerespon.body("firstname", Matchers.equalTo("Gurpreet1"));
        validatsblerespon.body("lastname", Matchers.equalTo("Batth"));

    }

    }




