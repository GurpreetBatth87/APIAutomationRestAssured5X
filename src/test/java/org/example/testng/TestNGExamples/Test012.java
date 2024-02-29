package org.example.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test012 {

    @Parameters("browser")
    @Test(priority = 1)
    public void demo1(String value){
        System.out.println("Browser is "+value);
    }

}
