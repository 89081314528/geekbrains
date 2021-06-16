package ru.geekbrains;

public class Team {
    String name;
    Creature[] creatures;

    public Team(String name, Creature creature1, Creature creature2, Creature creature3) {
        this.name = name;
        this.creatures = new Creature[]{creature1, creature2, creature3};
    }

    public void info() {
        System.out.print("Команда " + name + " состоит из участников: ");
        for (Creature creature : creatures) {
            System.out.print(creature.getName() + " ");
        }
        System.out.println();
    }

    public void winners() {
        for (Creature creature : creatures) {
            if (creature.isRunSussecc() && creature.isJumpSussecc()) {
                if (creature instanceof Cat) {
                    System.out.println("Кот прошел полосу препятствий");
                } else if (creature instanceof Human) {
                    System.out.println("Человек прошел полосу препятствий");
                } else if (creature instanceof Robot) {
                    System.out.println("Робот прошел полосу препятствий");
                }
            }
        }
    }
}
