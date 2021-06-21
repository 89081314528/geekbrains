package ru.geekbrains;

public class Wall implements Barrier{
    private int size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public void path(Creature creature) {
        if (size > creature.getMaxJumpDistance()) {//существо прыгает, а этот код перенести в метод прыгает
            // в существе
            creature.setOverride(false);
        }
    }
}
