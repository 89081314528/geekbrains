package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Задача:
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку.
 */
public class Lesson1 {
    public static void main(String[] args) {
        String[] array = {"cat", "dog"};
        change(array); //ковариантность - в массиве можно использовать классы-наследники, в дженериках это сделать нельзя
        List <String> list = new ArrayList<>();
        list.add("pig");
        list.add("snake");
        change(list); // инвариантность - тип листа нужно использовать такой же, как в методе
        // если в методе напишем public static void change(List<Object> list) {} - не будет работать
        System.out.println(list);
        System.out.println(convertArrayToList(array));
    }

    public static <T> void change(T [] array) { // если сделать массив обджектов, то в методе в качестве аргумента можно
        // использовать классы-наследники, например, стринг
        T current = array[0];
        array[0] = array[1];
        array[1] = current;
    }
    public static <T> void change(List<T> list) { // если сделать лист обджектов, и вызвать метод с аргументом лист строк
        // программа не будет работать
        T current = list.get(0);
        T next = list.get(1);
        list.set(0,next);
        list.set(1,current);
    }


    public static <T> ArrayList convertArrayToList(T [] massive) {
        ArrayList <T> list = new ArrayList<>();
        for (T o : massive) {
            list.add(o);
        }
        return list;
    }
}
