package ru.geekbrains.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        App app = new App();
        app.start(MyTestClass.class);
    }

    private static void start(Class<?> myTestClass) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Object myTestClass1 = myTestClass.newInstance();
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        Method[] declaredMethods = myTestClass.getDeclaredMethods();// здесь будут все методы MyTestClass
        List<Method> testMethods = new ArrayList<>(); // здесь будут методы с аннотацией Test
        Method before = null;
        Method after = null;
        for (Method method : declaredMethods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                before = method;
                countBeforeSuite++;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                after = method;
                countAfterSuite++;
            }
            if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
            }
        }

        if (countAfterSuite > 1 || countBeforeSuite > 1) {
            throw new RuntimeException();
        }

        if (before != null) {
            before.invoke(myTestClass1, null);
        }

        Comparator methodsComparator = new MethodsComparator();
        Collections.sort(testMethods, methodsComparator);

        for (Method method : testMethods) {
            method.invoke(myTestClass1, null);
        }
        if (after != null) {
            after.invoke(myTestClass1, null);
        }
    }
}
