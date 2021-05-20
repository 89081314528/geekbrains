package ru.geekbrains;

import java.util.Arrays;

/**
 * 1. Посчитать количество букв в числе
 */
public class CountChars {
    public static void main(String[] args) {
        String str = "njndkjsndksjkdjkjkjkj";
        int[] array = new int[128];
        char[] chars = str.toCharArray();   // char это цифра, но когда вызываем метод print, печатается буква
        System.out.println(Arrays.toString(chars));
        for (char ch : chars) {
            array[ch] = array[ch] + 1;
        }
        for (char i = 0; i < array.length; i++) {//?
            if(array[i] !=0) {
                System.out.println(i + " встретилось " + array[i] + " раза");
            }
        }
    }
}
