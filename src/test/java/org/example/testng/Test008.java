package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Test008 {
@Test
    public void testcase001(){
    //Assert - ar == er
    // TWO type Asseration
    //Soft Asseration

    //Expected Result - Pramod\
    //Actual resulr -- dutta
    SoftAssert s = new SoftAssert();
    s.assertEquals(true,false,"true shoulb be equal to false");
    System.out.println("plsease execute me ");
    s.assertAll();




    //hard asseration
    Assert.assertEquals(true,true,"failed");
    System.out.println("thiss will be failed");



}

}
