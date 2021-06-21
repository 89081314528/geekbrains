package ru.geekbrains;

public class TreadMill implements Barrier{
    private int size;

    public TreadMill(int size) {
        this.size = size;
    }

    @Override
    public void path(Creature creature) {
        if (size > creature.getMaxRunDistance()) {
            creature.setOverride(false);
        }
    }
}
