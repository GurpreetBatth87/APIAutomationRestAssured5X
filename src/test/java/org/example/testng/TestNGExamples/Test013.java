package org.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test013 {
    //Data Driven Testing
    //Test - with multiple inputes
    //LoginTest ==>>100
    //Regestration user

    // Data Provider -- TestData
    @DataProvider
public Object[][] getdata(){
    return new Object[][]{
            new Object[]{"admin","admin"},
            new Object[]{"pass","admin"},
            new Object[]{"add","test"},
            new Object[]{"admin","dell"},
    };
}

@Test(dataProvider = "getdata")
    public void login(String username , String password){
        System.out.println(username);
        System.out.println(password);
    }
}
