package ru.geekbrains.lesson6;

public abstract class Animal {
    private String name;
    private static int countAnimals;

    public static void getCountAnimals() {
        System.out.println(("Создано " + countAnimals + " животных"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public abstract void run (int distance);
    public abstract void swim (int distance);
}
