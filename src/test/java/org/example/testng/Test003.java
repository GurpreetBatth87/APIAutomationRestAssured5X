package org.example.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test003 {
    String token;

    Integer bookingID ;


    public String getToken(){
        token = "123";
        return token;

    }
    @BeforeTest
    public void getTokenAndBookingID(){
        token =getToken();

        bookingID = 123;

    }


    @Test
    public void testPUTRew(){
        System.out.println(token);
    }
}
