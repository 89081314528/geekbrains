package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dictionary {
    private HashMap<String, ArrayList<Integer>> dictionary = new HashMap<>();

    public HashMap<String, ArrayList<Integer>> getDictionary() {
        return dictionary;
    }

    public Dictionary() {
    }
    public void add(String surname, Integer number) {
        ArrayList<Integer> list;
        if (dictionary.containsKey(surname)) {
            list = dictionary.get(surname);
        } else {
            list = new ArrayList<>();
            list.add(number);
        }
        dictionary.put(surname, list);
    }

    public List<Integer> get(String surname) {
        return dictionary.get(surname);
    }
}
