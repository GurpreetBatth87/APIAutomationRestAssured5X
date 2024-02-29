package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test009 {
@Test
    public void testcase001(){
    //hard asseration
    Assert.assertEquals(true,false,"failed");
    System.out.println("thiss will be failed");

}

    @Test
    public void testcase00(){
        //hard asseration
        Assert.assertEquals(true,true,"failed");
        System.out.println("thiss will be failed");

    }

}
