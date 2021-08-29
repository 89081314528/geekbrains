package ru.geekbrains;

import java.util.ArrayList;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */

public class Lesson1 {
    public static void main(String[] args) {
        String[] array = {"cat", "dog"};
        change(array);
        System.out.println(convertArrayToList(array));
    }

    public static <T> void change(T[] array) {
        T current = array[0];
        array[0] = array[1];
        array[1] = current;
    }

    public static <T> ArrayList<T> convertArrayToList(T[] massive) {
        ArrayList<T> list = new ArrayList<>();
        for (T o : massive) {
            list.add(o);
        }
        return list;
    }
}
