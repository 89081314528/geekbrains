package ru.geekbrains;

public interface Creature {
    void jump(Wall wall);
    void run(TreadMill treadMill);
    boolean isJumpSussecc();
    boolean isRunSussecc();
}
