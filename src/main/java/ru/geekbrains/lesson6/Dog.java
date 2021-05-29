package ru.geekbrains.lesson6;

public class Dog extends Animal{
    private static int countDogs;

    public static void getCountDogs() {
        System.out.println(("Создано " + countDogs + " собак"));
    }

    public Dog(String name) {
        super(name);
        countDogs ++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не пробежит " + distance + " метров");
        } else {
            System.out.println("Собака " + getName() + " пробежала " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака не проплывет " + distance + " метров");
        } else {
            System.out.println("Собака " + getName() + " проплыла " + distance + " метров");
        }
    }
}
