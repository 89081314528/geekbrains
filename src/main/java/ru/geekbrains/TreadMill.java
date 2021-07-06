package ru.geekbrains;

public class TreadMill implements Barrier {
    private int size;

    public TreadMill(int size) {
        this.size = size;
    }

    @Override
    public void pass(Creature creature) {
        creature.run(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
