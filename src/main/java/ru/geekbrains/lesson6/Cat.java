package ru.geekbrains.lesson6;

public class Cat extends Animal {
    public static final int MAX_RUN_DISTANCE = 200;
    private static int countCats;

    public static void getCountCats() {
        System.out.println(("Создано " + countCats + " котов"));
    }

    public Cat(String name) {
        super(name);
        countCats++;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println("Кот не пробежит " + distance + " метров");
        } else {
            System.out.println("Кот " + getName() + " пробежал " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не плавают");
    }

    public void voice() {
        System.out.println("Кот " + getName() + " сказал Мяяяяяяууу");
    }
}
