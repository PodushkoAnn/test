package tested_classes;

import annotations.BeforeSuite;

public class Victim {


    @BeforeSuite
    public void one(){
        System.out.println("выполнился BeforeSuite");
    }

    @BeforeSuite
    public void two(){
        System.out.println("выполнился BeforeSuite");
    }
}