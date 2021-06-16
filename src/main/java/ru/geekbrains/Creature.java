package ru.geekbrains;

public interface Creature {
    public String getName();
    void jump(Wall wall);
    void run(TreadMill treadMill);
    boolean isJumpSussecc();
    boolean isRunSussecc();
}
