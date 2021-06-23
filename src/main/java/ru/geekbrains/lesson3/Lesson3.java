package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 * 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
 * искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
 * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны. Желательно
 * не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 * через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника
 */
public class Lesson3 {
    public static void main(String[] args) {
        String[] arrayAnimals = {"cat", "dog", "monkey", "giraffe", "cat", "elephant", "tiger", "cat", "tiger", "dog"};
        HashMap<String, Integer> mapAnimals = new HashMap<>();
        for (String animal : arrayAnimals) {
            if (mapAnimals.containsKey(animal)) {
                mapAnimals.put(animal, mapAnimals.get(animal) + 1);
            } else {
                mapAnimals.put(animal, 1);
            }
        }
        for (String s : mapAnimals.keySet()) {
            System.out.println("Слово " + s + " встречается " + mapAnimals.get(s) + " раз");
        }


        Directory directory = new Directory();
        directory.add("Иванов", 123);
        directory.add("Петров", 222);
        directory.add("Сидоров", 333);
        directory.add("Иванов", 556);
        directory.add("Сидоров", 667);

        for (Map.Entry<String, ArrayList<Integer>> entry : directory.getDirectory().entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        System.out.println(directory.getDirectory().get("Иванов"));
        System.out.println(directory.get("Сидоров"));
    }
}
