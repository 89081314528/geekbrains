package ru.geekbrains;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    final ArrayList<T> fruitBox; // обязательно final?

    public Box(ArrayList<T> fruitBox) {
        this.fruitBox = fruitBox;
    }
    
    public void add (T fruit) { // можно проверять тип каждого добавленного фрукта и кидать исключение,
        // если он не совпадает с первым добавленным
        fruitBox.add(fruit);
    }


    public double getWeight() {
        if (fruitBox.get(0) instanceof Apple) { // предполагаем, что все фрукты в одной корзине одинаковые
            return fruitBox.size();
        } else if (fruitBox.get(0) instanceof Orange) {
            return fruitBox.size() * 1.5; // здесь можно использовать вес из класса фрукт?
        }
        return 0;
    }

    public boolean compare (Box box) {
        if (this.getWeight() == box.getWeight()) {
            return true;
        }
        return false;
    }

    public void transfer (Box <T> newBox) {
        for (T fruit : this.fruitBox) {
            newBox.add(fruit);
            this.fruitBox.remove(fruit);
        }
    }
}


