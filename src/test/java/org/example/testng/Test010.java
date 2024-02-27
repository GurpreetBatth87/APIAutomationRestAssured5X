package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test010 {
@Test
    public void serverstartokk(){
    System.out.println("Server will be Start");

}

    @Test(dependsOnMethods = "serverstartokk")
    public void method01(){

        System.out.println("Method1");

    }

}
