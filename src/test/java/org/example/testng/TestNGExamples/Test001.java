package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test001 {

    @BeforeMethod
    public void test04(){
       // Assert.assertEquals(true,true);
        //why->Read from eXCEL FILE
        //FILE TEXT , JASON , CSV , DATABASSE
        //Configration load extra
        System.out.println("Before method");

    }
@Test
    public void test05(){
         System.out.println("Test Demo");
    }
    @Test
    public void test06(){
        System.out.println("Test Demo new ");
    }

    @AfterMethod
    public void Aftermethod(){
        //close the file - here write the code
        System.out.println("After Method");
    }
}
