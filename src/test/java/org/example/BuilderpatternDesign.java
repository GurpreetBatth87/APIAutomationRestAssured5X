package org.example;

public class BuilderpatternDesign {
    public BuilderpatternDesign stage1(){
        System.out.println("stage 1");
        return this;
    }

    public BuilderpatternDesign stage2(){
        System.out.println("stage 2");
        return this;
    }

    public BuilderpatternDesign stage3(){
        System.out.println("stage 3");
        return this;
    }


    public static void main(String[] args) {
        BuilderpatternDesign b = new BuilderpatternDesign();
        b.stage1().stage2().stage3();
    }

}
