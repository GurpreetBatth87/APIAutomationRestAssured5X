package org.example.testng;

import org.testng.annotations.Test;

public class Test011 {
@Test(groups = {"init"})
    public void gettoken(){
    System.out.println("Server will be Start");

}

    @Test(groups = {"init"},priority = -1,enabled = false)
    public void getbookingId(){

        System.out.println("Method1");

    }
    @Test(dependsOnGroups ={"init.*"})
    public void method02(){

        System.out.println("Method2");

    }

}
