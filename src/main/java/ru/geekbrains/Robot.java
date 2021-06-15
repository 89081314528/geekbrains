package ru.geekbrains;

public class Robot implements Creature {
    final String name;

    public Robot(String name) {
        this.name = name;
    }

    public static final int MAX_RUN_DISTANCE = 30000;
    public static final int MAX_JUMP_DISTANCE = 5;
    boolean isJump = false;
    boolean isRun = false;


    @Override
    public void jump(Wall wall) {
        if (wall.height > MAX_JUMP_DISTANCE) {
            System.out.println("Робот не перепрыгнул стену");
            isJump = false;
        } else {
            System.out.println("Робот перепрыгнул стену");
            isJump = true;
        }
    }

    @Override
    public void run(TreadMill treadMill) {
        if (treadMill.length > MAX_RUN_DISTANCE) {
            System.out.println("Робот не пробежал");
            isRun = false;
        } else {
            System.out.println("Робот пробежал");
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
