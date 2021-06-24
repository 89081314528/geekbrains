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
            setOverride(false);
        }
    }
    @Override
    public void jump(Barrier barrier){
        if (barrier.getSize() > MAX_JUMP_DISTANCE) {
            setOverride(false);
        }
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
