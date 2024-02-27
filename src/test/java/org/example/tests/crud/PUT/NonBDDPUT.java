package org.example.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {
    RequestSpecification RequestSpec;

    ValidatableResponse validationResponse;

    String token= "339797f5794f7fe";


    @Test
    public void testPutRequesT(){

        //Url
        // Auth-- token = 158115c008b5558
        //Header
        //id - 189
        // payload

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

        RequestSpec= RestAssured.given();
        RequestSpec.baseUri("https://restful-booker.herokuapp.com");
        RequestSpec.basePath("/booking/2508");
        RequestSpec.contentType(ContentType.JSON);
        RequestSpec.cookie("token",token);

        RequestSpec.body(payload).log().all();

        //calling PUT methos on URI After hitting we get responsr

        Response Response = RequestSpec.when().put();


        //Get validate response to perfortm validation
        validationResponse = Response.then().log().all();
        validationResponse.statusCode(200);
        validationResponse.body("firstname", Matchers.equalTo("Gurpreet1"));
        validationResponse.body("lastname", Matchers.equalTo("Batth"));

    }
}
