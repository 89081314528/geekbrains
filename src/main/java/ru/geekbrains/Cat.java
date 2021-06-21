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
    public int getMaxRunDistance() {
        return MAX_RUN_DISTANCE;
    }

    @Override
    public int getMaxJumpDistance() {
        return MAX_JUMP_DISTANCE;
    }

    @Override
    public boolean isOverride() {
        return isOverride;
    }

    @Override
    public void setOverride(boolean override) {
        isOverride = override;
    }

    @Override
    public String getName() {
        return name;
    }
}
