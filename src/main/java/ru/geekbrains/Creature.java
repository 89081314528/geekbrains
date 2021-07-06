package ru.geekbrains;

public interface Creature {
    String getName();
    boolean isOverride();
    void jump(Barrier barrier);
    void run(Barrier barrier);
}
