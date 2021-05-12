package ru.geekbrains.lesson2;

/**
 * 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
 * (включительно), если да – вернуть true, в противном случае – false.
 * 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
 * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
 * 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
 * отрицательное, и вернуть false если положительное.
 * 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
 * указанную строку, указанное количество раз;
 * 5. Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не
 * високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(within10And20(10, 20));
        positiveOrNegative(-10);
        System.out.println(isNegative(0));
        printStringNtimes("I love ice cream", 5);
        System.out.println(isLeap(8));
        System.out.println(isLeap(100));
        System.out.println(isLeap(400));
        System.out.println(isLeap(105));
    }

    public static boolean within10And20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void positiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringNtimes(String str, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            }
            if (year % 100 == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}



