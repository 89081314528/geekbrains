package ru.geekbrains;

public class Robot implements Creature {
    final String name;
    private final int MAX_RUN_DISTANCE = 30000;
    private final int MAX_JUMP_DISTANCE = 5;
    boolean isOverride = true;

    public Robot(String name) {
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
