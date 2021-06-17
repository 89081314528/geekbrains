package ru.geekbrains;

public class Team {
    String name;
    Creature[] creatures;

    public Creature[] getCreatures() {
        return creatures;
    }

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
            if (creature.isOverride()) {
                System.out.println(creature.getName() + "  прошел полосу препятствий");
            }
        }
    }
}
