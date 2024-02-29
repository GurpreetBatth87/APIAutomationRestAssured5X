package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test00 {
    @BeforeSuite
    void demo1(){
        System.out.println("**Before Suite **");
    }

    @BeforeTest
    void demo2(){
        System.out.println("(( Before Test))");
    }

    @BeforeClass
    void demo3(){
        System.out.println("**** Before Class ");
    }

    @Test
    public void testcase1(){
        System.out.println("**** Class ");

    }
@AfterMethod
     void testcase2(){
    System.out.println(":After Method ");
    }
    @AfterClass
    void demo7(){
        System.out.println(":After Class ");
    }
    @AfterTest
    void demo8(){
        System.out.println(":After Test ");
    }

    @AfterSuite
    void demo9(){
        System.out.println("After Test");
    }


}
