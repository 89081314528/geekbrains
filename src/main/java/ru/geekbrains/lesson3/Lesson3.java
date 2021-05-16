package ru.geekbrains.lesson3;

import java.util.Arrays;

/**
 * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
 * С помощью цикла и условия заменить 0 на 1, 1 на 0;
 * 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
 * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 * заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
 * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
 * то есть [0][0], [1][1], [2][2], …, [n][n];
 * 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
 * типа int длиной len, каждая ячейка которого равна initialValue;
 * 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
 * 7. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
 * если в массиве есть место, в котором сумма левой и правой части массива равны.
 * Примеры:
 * checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
 * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
 * граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
 * 8. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
 * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
 * Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
 * (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
 * При каком n в какую сторону сдвиг можете выбирать сами.
 */
public class Lesson3 {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array1) + " Первоначальный массив");
        System.out.println(Arrays.toString(change0to1and1to0(array1)) + " В массиве заменили 0 на 1, 1 на 0");

        System.out.println("Задача 2");
        fillArray1to100();

        System.out.println("Задача 3");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array3) + " Первоначальный массив");
        changeArray(array3);

        System.out.println("Задача 4");
        fillDiagonal(7);

        System.out.println("Задача 5");
        System.out.println(Arrays.toString(fillArrayByLengthAndValue(20, 3)));

        System.out.println("Задача 6");
        int[] array6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        findMinAndMax(array6);

        System.out.println("Задача 7");
        int[] array7 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(changeBalance(array7));
    }

    public static boolean changeBalance (int[] array) {
        int sumOfLeftPart = 0;
        int sumOfRightPart = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfLeftPart = sumOfLeftPart + array[i];
            for (int j = i + 1; j < array.length; j++) {
                sumOfRightPart = sumOfRightPart + array[j];
            }
            if (sumOfLeftPart == sumOfRightPart) {
                return true;
            }
            sumOfRightPart = 0;
        }
        return false;
    }

    public static void findMinAndMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    public static int[] change0to1and1to0(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    public static void fillArray1to100() {
        int[] array2 = new int[100];
        for (int i = 0; i < 100; i++) {
            array2[i] = i + 1;
        }
        System.out.println("array2 = " + Arrays.toString(array2));
    }

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array) + " В массиве числа, меньшие 6, умножили на 2");
    }

    public static void fillDiagonal(int len) {
        int[][] array = new int[len][len];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
            }
        }
        printArray(array);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] fillArrayByLengthAndValue(int len, int initialValue) {
        int[] array5 = new int[len];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = initialValue;
        }
        return array5;
    }
}

