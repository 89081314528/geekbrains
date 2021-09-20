package ru.geekbrains.lesson6;

import java.sql.Array;

/**
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
 * иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
 * (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
public class Arr {

    public int[] selectAfterLastFour(int[] array) {
        int countFours = 0;
        int indexLastFour = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                countFours++;
                indexLastFour = i;
            }
        }
        if (countFours == 0) {
            throw new RuntimeException("bad array");
        }
        int newArraySize = array.length - indexLastFour;
        int[] newArray = new int[newArraySize];
        for (int i = 0; i < newArraySize; i++) {
                newArray[i] = array[indexLastFour + i];

        }
        return newArray;
    }

    public boolean consistOneTwo(int[] arr) {
        int countOne = 0;
        int countFour = 0;
        int countOther = 0;
        for (int i : arr) {
            if (i == 1) {
                countOne ++;
            } else if (i == 4) {
                countFour ++;
            } else {
                countOther ++;
            }
        }

        if (countOne > 0 && countFour > 0 && countOther == 0) {
            return true;
        } else {
            return false;
        }
    }
}
