package ru.geekbrains;

public class Cat implements Creature {
    final String name;

    public String getName() {
        return name;
    }

    public static final int MAX_RUN_DISTANCE = 300;
    public static final int MAX_JUMP_DISTANCE = 2;
    boolean isJump = true;
    boolean isRun = true;

    public Cat(String name) {
        this.name = name;
    }


    @Override
    public void jump(Wall wall) {
        if (wall.height > MAX_JUMP_DISTANCE) {
            System.out.println("Кот не перепрыгнул стену");
            isJump = false;
        } else {
            System.out.println("Кот перепрыгнул стену");
            isJump = true;
        }
    }

    @Override
    public void run(TreadMill treadMill) {
        if (treadMill.length > MAX_RUN_DISTANCE) {
            System.out.println("Кот не пробежал");
            isRun = false;
        } else {
            System.out.println("Кот пробежал");
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
