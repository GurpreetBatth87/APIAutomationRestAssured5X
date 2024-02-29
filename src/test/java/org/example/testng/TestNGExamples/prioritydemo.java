package org.example.testng;

import org.testng.annotations.Test;

public class prioritydemo {
    @Test (priority = 1,groups = {"reg"})
    void demo1(){
        System.out.println("A");
    }
    @Test (priority = 2)
    void demo2(){
        System.out.println("A");
    }
    @Test (priority = 3)
    void demo12(){
        System.out.println("A");
    }
}
