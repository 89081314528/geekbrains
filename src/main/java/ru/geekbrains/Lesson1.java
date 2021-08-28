package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Задача:
 * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можно использовать ArrayList;
 * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
 * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
 * в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * Не забываем про метод добавления фрукта в коробку.
 */

public class Lesson1 {
    public static void main(String[] args) {
        String[] array = {"cat", "dog"};
        change(array);
        System.out.println(convertArrayToList(array));

        Box<Apple> appleBox = new Box<>(new ArrayList<>()); // как сделать чтобы в коробке были фрукты одного типа
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Orange> orangeBox = new Box<>(new ArrayList<>());// нормально, что в скобках new ArrayList<>()
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        Box<Apple> appleBox2 = new Box<>(new ArrayList<>());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        appleBox.transfer(appleBox2); // не работает!!!!!!
        System.out.println(appleBox.fruitBox);
        System.out.println(appleBox2.fruitBox);
    }

    public static <T> void change(T [] array) {
        T current = array[0];
        array[0] = array[1];
        array[1] = current;
    }

    public static <T> ArrayList <T> convertArrayToList(T [] massive) {
        ArrayList <T> list = new ArrayList<>();
        for (T o : massive) {
            list.add(o);
        }
        return list;
    }
}
