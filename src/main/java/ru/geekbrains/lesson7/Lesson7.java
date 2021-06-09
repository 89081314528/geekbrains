package ru.geekbrains.lesson7;

/**
 * 1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true.
 * 3. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может
 * быть наполовину сыт (это сделано для упрощения логики программы).
 * 4. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
 * потом вывести информацию о сытости котов в консоль.
 * 5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Lesson7 {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 10),
                new Cat("Vasya", 20),
                new Cat("Pushok", 30),
                new Cat("Murzik", 30),
                new Cat("Chernysh", 30)
        };
        Plate plate = new Plate(100);
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
        }
        for (Cat cat : cats) {
            if (cat.isFull()) {
                System.out.println("Кот " + cat.getName() + " сыт");
            } else {
                System.out.println("Кот " + cat.getName() + " голоден");
            }
        }
        plate.addFood(100);
        plate.info();
        cats[1].eat(plate);
    }
}

