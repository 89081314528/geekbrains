package ru.geekbrains;
/**
 * Число Фиббоначи (сумма двух предыдущих цифр)
 */
public class Fibbonachy {
    public static void main(String[] args) {
        System.out.println(recFib(8));
        System.out.println(fib(8));
    }
    public static int recFib(int num) {
        if (num < 3) {
            return 1;
        } else {
            return recFib(num - 1) + recFib(num - 2);
        }
    }
    public static int fib(int num) {
        int previos = 1;
        int next = 1;
        int sum = 0;
        for (int i = 3; i <= num; i++) {
            sum = previos + next;
            previos = next;
            next = sum;
        }
        return sum;
    }
}
