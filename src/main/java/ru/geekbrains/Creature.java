package ru.geekbrains;

public interface Creature {
    String getName();
    int getMaxRunDistance();
    int getMaxJumpDistance();
    void setOverride(boolean override);
    boolean isOverride();
}
