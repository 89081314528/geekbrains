package ru.geekbrains.lesson7;

import java.lang.reflect.Method;

public class MyTestClass {
    @Test(queue = 5)
    public static void test1() {
        System.out.println("Проведен тест 1");
    }

    @Test(queue = 1)
    public static void test2() {
        System.out.println("Проведен тест 2");
    }

    @Test(queue = 4)
    public static void test3() {
        System.out.println("Проведен тест 3");
    }

    @Test(queue = 10)
    public static void test4() {
        System.out.println("Проведен тест 4");
    }

    @BeforeSuite
    public static void test5() {
        System.out.println("Проведен тест 5");
    }

    @AfterSuite
    public static void test6() {
        System.out.println("Проведен тест 6");
    }

}
