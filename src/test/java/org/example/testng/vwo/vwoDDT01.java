package org.example.testng.DDt;

import org.testng.annotations.Test;

public class DDT01 {
    // test data-- format -- excelfile -- data provider
    //Read the Excel file
    // Apache POI - 60 - 70 % Little dewfecult to undersatnd first time
    // Fillo Lobrary - 30% - super easy

    //test case _Login where we will inject the username and password

    @Test(dataProvider = "getdata",dataProviderClass = UtilExcel.class)
    public void testLogin(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }
}
