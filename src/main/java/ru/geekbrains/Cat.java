package ru.geekbrains;

public class Cat implements Creature{

    public static final int MAX_RUN_DISTANCE = 500;
    public static final int MAX_JUMP_DISTANCE = 2;


    @Override
    public void jump(Wall wall) {
        if (wall.height > MAX_JUMP_DISTANCE) {
            System.out.println("Кот не перепрыгнул стену");
        } else {
            System.out.println("Кот перепрыгнул стену");
        }
    }

    @Override
    public void run(TreadMill treadMill) {
        if (treadMill.length > MAX_RUN_DISTANCE) {
            System.out.println("Кот не пробежал");
        } else {
            System.out.println("Кот пробежал");
        }
    }
}
