package ru.geekbrains;

public class Wall implements Barrier{
    public int size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public void path(Creature creature) {
        if (size > creature.getMaxJumpDistance()) {
            creature.setOverride(false);
        }
    }
}
