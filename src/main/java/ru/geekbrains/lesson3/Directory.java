package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory {
    private HashMap<String, ArrayList<Integer>> directory = new HashMap<>();

    public HashMap<String, ArrayList<Integer>> getDirectory() {
        return directory;
    }

    public Directory() {
    }
    public void add(String surname, Integer number) {
        ArrayList<Integer> list = new ArrayList<>();
        if (directory.containsKey(surname)) {
            list = directory.get(surname);
        }
        list.add(number);
        directory.put(surname, list);
    }

    public List<Integer> get(String surname) {
        return directory.get(surname);
    }
}
