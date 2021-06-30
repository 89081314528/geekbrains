package ru.geekbrains;

public class Human implements Creature {
    final String name;
    private final int MAX_RUN_DISTANCE = 3000;
    private final int MAX_JUMP_DISTANCE = 3;
    boolean isOverride = true;

    public Human(String name) {
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
    public String getName() {
        return name;
    }

    @Override
    public boolean isOverride() {
        return isOverride;
    }
}
