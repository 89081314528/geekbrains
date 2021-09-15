package ru.geekbrains.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void end(Car c) {
                System.out.println(c.getName() + " закончил этап: " + description);
    }
    @Override
    public void wait(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
