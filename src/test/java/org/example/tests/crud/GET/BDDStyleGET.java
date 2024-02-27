package org.example.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {
        // GET REq -https://api.zippopotam.us/IN/143304

        //given  ----- >
        //URL
        //HEADER
        //GET mETHOD        //
        //BASE URL - https://api.zippopotam.us
        //BASE PATH -=/IN/143304
        //AUTH - BASIC,dIGER ,jWT,BEARER TOKERN , AUTH 2.0?= NO
        //

        // When
        //PAYLOAD --NO
        //Get Method


        //Then() --- >
        //Validation
        //Status code
        //response body
        // Time ,Header, cookie
        //
        //


        //Gerkin --> Given , When , Then --> Stylr -- >
        // BDD -- Framework Diffrent
        //Synctax - Gerkin Sytax(given , when , then )
// no BDD Still Gerkin syntex work

        //RestAssured.given();

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/143304")

                .when()
                .get()

                .then().log().all().statusCode(200);






    }
}
