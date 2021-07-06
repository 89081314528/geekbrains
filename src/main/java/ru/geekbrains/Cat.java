package ru.geekbrains;

public class Cat implements Creature {
    final String name;
    private final int MAX_RUN_DISTANCE = 300;
    private final int MAX_JUMP_DISTANCE = 2;
    boolean isOverride = true;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(Barrier barrier) {
        if (barrier.getSize() > MAX_RUN_DISTANCE) {
            isOverride = false;
        }
    }

    @Override
    public void jump(Barrier barrier) {
        if (barrier.getSize() > MAX_JUMP_DISTANCE) {
            isOverride = false;
        }
    }

    @Override
    public boolean isOverride() {
        return isOverride;
    }

    @Override
    public String getName() {
        return name;
    }
}
