import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {

    public static void start(Class cl) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        run(cl);
    }

    public static void start(String name) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class cl = Class.forName(name);
        run(cl);
    }

    private static void run(Class cl) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = cl.getDeclaredMethods();

        if (checkValidity(methods)) {
            queueRun(methods, cl);
        } else throw new RuntimeException();
    }

    private static void queueRun(Method[] methods, Class cl) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(cl.newInstance());
                break;
            }
        }

        for (int i = 1; i < 11; i++) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class) && method.getAnnotation(Test.class).priority() == i) {
                    method.invoke(cl.newInstance());
                }
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(cl.newInstance());
                break;
            }
        }
    }

    private static boolean checkValidity(Method[] methods) {
        int hasBefore = 0;
        int hasAfter = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) hasBefore++;
            if (method.isAnnotationPresent(AfterSuite.class)) hasAfter++;
        }
        if (hasBefore > 1 || hasAfter > 1) return false;
        return true;
    }
}

