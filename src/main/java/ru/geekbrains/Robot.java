package ru.geekbrains;

public class Robot implements Creature {
    final String name;
    public static final int MAX_RUN_DISTANCE = 30000;
    public static final int MAX_JUMP_DISTANCE = 5;
    boolean isOverride = true;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
    public void setOverride(boolean override) {
        isOverride = override;
    }

    @Override
    public boolean isOverride() {
        return isOverride;
    }
}
