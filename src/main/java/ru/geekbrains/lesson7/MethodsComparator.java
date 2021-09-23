package ru.geekbrains.lesson7;

import java.lang.reflect.Method;
import java.util.Comparator;

public class MethodsComparator implements Comparator<Method> {
    @Override
    public int compare(Method o1, Method o2) {
        return o1.getAnnotation(Test.class).queue() - o2.getAnnotation(Test.class).queue();
    }
}
