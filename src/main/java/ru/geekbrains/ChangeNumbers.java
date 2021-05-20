package ru.geekbrains;

/**
 * Поменять местами числа
 */
public class ChangeNumbers {
    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
