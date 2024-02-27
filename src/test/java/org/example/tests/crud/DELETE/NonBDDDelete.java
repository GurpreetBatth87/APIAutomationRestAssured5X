package org.example.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDelete {
    RequestSpecification RequestSpec;

    ValidatableResponse validationResponse;

    String token= "da9b1549bf0a970";


    @Test
    public void testPutRequesT(){

        //Url
        // Auth-- token = 158115c008b5558
        //Header
        //id - 189
        // payload

//        String payload ="{\n" +
//                "    \"firstname\" : \"Gurpreet1\",\n" +
//                "    \"lastname\" : \"Batth\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
//        String payload2 ="{\n" +
//                "    \"firstname\" : \"Gurpreet\",\n" +
//                "    \"lastname\" : \"Manpreet\"\n" +
//                "}";

        RequestSpec= RestAssured.given();
        RequestSpec.baseUri("https://restful-booker.herokuapp.com");
        RequestSpec.basePath("/booking/4668");
        RequestSpec.contentType(ContentType.JSON);
        RequestSpec.cookie("token",token);

       // RequestSpec.body(payload2).log().all();

        //calling PUT methos on URI After hitting we get responsr

        Response Response = RequestSpec.when().delete();


        //Get validate response to perfortm validation
        validationResponse = Response.then().log().all();
        validationResponse.statusCode(401);
//        validationResponse.body("firstname", Matchers.equalTo("Gurpreet1"));
//        validationResponse.body("lastname", Matchers.equalTo("Batth"));

    }
}
