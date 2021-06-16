package ru.geekbrains;

public class Human implements Creature {
    final String name;

    public String getName() {
        return name;
    }

    public static final int MAX_RUN_DISTANCE = 3000;
    public static final int MAX_JUMP_DISTANCE = 3;
    boolean isJump = true;
    boolean isRun = true;

    public Human(String name) {
        this.name = name;
    }


    @Override
    public void jump(Wall wall) {
        if (wall.height > MAX_JUMP_DISTANCE) {
            System.out.println("Человек не перепрыгнул стену");
            isJump = false;
        } else {
            System.out.println("Человек перепрыгнул стену");
            isJump = true;
        }
    }

    @Override
    public void run(TreadMill treadMill) {
        if (treadMill.length > MAX_RUN_DISTANCE) {
            System.out.println("Человек не пробежал");
            isRun = false;
        } else {
            System.out.println("Человек пробежал");
            isRun = true;
        }
    }

    @Override
    public boolean isJumpSussecc() {
        return isJump;
    }

    @Override
    public boolean isRunSussecc() {
        return isRun;
    }
}
