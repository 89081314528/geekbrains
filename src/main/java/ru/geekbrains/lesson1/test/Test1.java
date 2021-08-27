package ru.geekbrains.lesson1.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String[] array = {"cat", "dog"};
        change(array); //ковариантность - в массиве можно использовать классы-наследники, например, массив строк вместо
        // массива обджектов, в дженериках это сделать нельзя
        List<String> list = new ArrayList<>();
        list.add("pig");
        list.add("snake");
        change(list); // инвариантность - тип листа нужно использовать такой же, как в методе
        // если в методе напишем public static void change(List<Object> list) {} - не будет работать
        System.out.println(list);

    }

    public static void change(Object [] array) {
        Object current = array[0];
        array[0] = array[1];
        array[1] = current;
    }
    public static void change(List<String> list) { // если сделать лист обджектов, и вызвать метод с аргументом лист строк
        // программа не будет работать
        String current = list.get(0);
        String next = list.get(1);
        list.set(0,next);
        list.set(1,current);
    }
    // правильно делать параметризованные методы:
//        public static <T> void change(T [] array) {
//            T current = array[0];
//            array[0] = array[1];
//            array[1] = current;
//        }
//        public static <T> void change(List<T> list) {
//            T current = list.get(0);
//            T next = list.get(1);
//            list.set(0,next);
//            list.set(1,current);
//        }
}

