package ru.geekbrains.lesson6;

public class Dog extends Animal{
    public static final int MAX_RUN_DISTANCE = 500;
    public static final int MAX_SWIM_DISTANCE = 10;
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
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println("Собака не пробежит " + distance + " метров");
        } else {
            System.out.println("Собака " + getName() + " пробежала " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println("Собака не проплывет " + distance + " метров");
        } else {
            System.out.println("Собака " + getName() + " проплыла " + distance + " метров");
        }
    }
}
