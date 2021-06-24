package ru.geekbrains;

public class Wall implements Barrier {
    private int size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public void pass(Creature creature) {
        creature.jump(this);
    }

    @Override
    public int getSize() {
        return size;
    }

}
