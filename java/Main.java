import tested_classes.Animal;
import tested_classes.Victim;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        try {
            TestClass.start(Animal.class);
            TestClass.start("tested_classes.Victim");

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
