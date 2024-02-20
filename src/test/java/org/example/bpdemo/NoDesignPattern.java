package org.example.bpdemo;

public class NoDesignPattern {
    public void step1(){
        System.out.println("Step1");
    }

    public void step2(){
        System.out.println("Step2");
    }

    public void step3(){
        System.out.println("Step3");
    }

    public static void main(String[] args) {


        NoDesignPattern n = new NoDesignPattern();
        n.step1();
        n.step2();
        n.step3();

    }
}
