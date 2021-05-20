package ru.geekbrains;

/**
 * Посчитать сумму цифр числа
 */
public class CountNumbers {
    public static void main(String[] args) {
        int number = 3785;
        sum(number);
        System.out.println(sumRec(number));
    }

    public static void sum(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        System.out.println(sum);
    }

    public static int sumRec(int number) {
        if (number == 0) {
            return 0;
        } else {
            return number % 10 + sumRec(number / 10);
        }
    }
}
