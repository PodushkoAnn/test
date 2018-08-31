package tested_classes;


import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class Animal {
    private String name;

    public Animal(){
        name = "Некое животное";
    }

    public Animal(String name) {
        this.name = name;
    }

    @BeforeSuite
    public void voice(){
        System.out.println("выполнился BeforeSuite");
    }

    @Test (priority = 1)
    public void run(){
        System.out.println("выполнился run - Test, приоритет 1");
    }

    @Test (priority = 2)
    public void jump(){
        System.out.println("выполнился jump - Test, приоритет 2");
    }

    @Test (priority = 3)
    public void fly(){
        System.out.println("выполнился fly - Test, приоритет 3");
    }

    @Test (priority = 3)
    public void roar(){
        System.out.println("выполнился roar - Test, приоритет 3");
    }

    @Test (priority = 3)
    public void swim(){
        System.out.println("выполнился swim - Test, приоритет 3");
    }

    @Test
    public void roam(){
        System.out.println("выполнился roam - Test, приоритет 5 (default)");
    }

    @AfterSuite
    public void afterAll(){
        System.out.println("выполнился AfterSuite");
    }
}
