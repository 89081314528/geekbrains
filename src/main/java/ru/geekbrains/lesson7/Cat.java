package ru.geekbrains.lesson7;

import java.sql.SQLOutput;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean full = false;


    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }
    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

        public void eat(Plate p) {
            if (appetite > p.getFood()) {
                System.out.println("Кот " + name + " не может есть из тарелки");
            } else {
                p.decreaseFood(appetite);
                System.out.println("Кот " + name + " поел из тарелки");
                full = true;
            }
        }
}
