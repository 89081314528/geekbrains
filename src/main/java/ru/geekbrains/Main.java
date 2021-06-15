package ru.geekbrains;

/**
 * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
 * бегать и прыгать (методы просто выводят информацию о действии в консоль).
 * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 * соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
 * не смог пробежать и т.д.).
 * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор
 * препятствий.
 * 4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
public class Main {
    public static void main(String[] args) {
        Barrier[] obstacleCourse = {
                new Wall(2),
                new TreadMill(300),
                new Wall(3),
                new TreadMill(3000),
                new Wall(5),
                new TreadMill(30000),
                new Wall(10)
        };
        Creature[] creatures = {
                new Cat("Pushok"),
                new Human("Petya"),
                new Robot("Valley")
        };
        for (Creature creature : creatures) {
            for (Barrier barrier : obstacleCourse) {
                if (barrier instanceof Wall) {
                    creature.jump((Wall) barrier);
                    if (!creature.isJumpSussecc()) {
                        break;
                    }
                } else {
                    if (barrier instanceof TreadMill) {
                        creature.run((TreadMill) barrier);
                    }
                    if (!creature.isRunSussecc()) {
                        break;
                    }
                }
            }
        }
    }
}
