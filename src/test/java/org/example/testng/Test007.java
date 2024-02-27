package org.example.testng;

import org.testng.annotations.Test;

public class Test007 {

    @Test(groups = {"Sanity","QA"})
    public void sanityRun(){
        System.out.println("sanity");
        System.out.println("QA");
    }
    @Test(groups = {"Reg","Sanity","E2E","Preprod"})
    public void regRun(){
        System.out.println("Reg");
       // System.out.println("QA");
    }

    @Test(groups = {"test","Dev","Smoke"})
    public void SmokeRun(){
        System.out.println("Smoke");
//        System.out.println("QA");
    }
}
