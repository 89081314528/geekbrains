package ru.geekbrains;

import java.util.Arrays;

/**
 * Циклический сдвиг
 */
public class Shift {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int shift = 7;
        int i = 0;
        int current = array[0];
        do {
            int next = i + shift;
            if (next > array.length - 1) {
                next = next - array.length;
            }
            array[i] = array[next];
            i = i + shift;
            if (i > array.length - 1) {
                i = i - array.length;
            }
        }
        while (i != 0 && i + shift != 0);
        array[array.length - shift] = current;
        System.out.println(Arrays.toString(array));
    }
}
