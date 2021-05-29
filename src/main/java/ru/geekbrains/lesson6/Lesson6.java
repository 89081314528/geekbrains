package ru.geekbrains.lesson6;

/**
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 * Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет
 * плавать, собака 10 м.).
 * 4. * Добавить подсчет созданных котов, собак и животных.
 */

public class Lesson6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Васька");
        Animal cat3 = new Cat("Пушок");
        System.out.println(cat1.getName());
        cat1.run(500);
        cat2.run(100);
        cat3.swim(100);
        cat1.voice();
        ((Cat) cat3).voice();

        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Рик");
        dog1.run(300);
        dog2.swim(5);

        Animal.getCountAnimals();
        Cat.getCountCats();
        Dog.getCountDogs();


    }
}
