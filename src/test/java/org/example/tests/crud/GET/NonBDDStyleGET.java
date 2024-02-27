package org.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {
    //GET request
    //BDD style  and non BDD style

    // given , when . then() . builder pattern
    public static void main(String[] args) {
        //https://restful-booker.herokuapp.com/booking/189

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/189").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);


        //Testing Framework -- > Allow us to execute the test casew
        // 1 main --? it will execute all the testcase that we have mentioned


    }
}
