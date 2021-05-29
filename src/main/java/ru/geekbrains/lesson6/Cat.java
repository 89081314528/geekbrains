package ru.geekbrains.lesson6;

public class Cat extends Animal{
    private static int countCats;

    public static void getCountCats() {
        System.out.println(("Создано " + countCats + " котов"));
    }

    public Cat(String name) {
        super(name);
        countCats ++;
    }

    @Override
    public void run(int distance) {
    if (distance > 200) {
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
