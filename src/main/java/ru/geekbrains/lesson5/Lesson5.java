package ru.geekbrains.lesson5;

import java.util.concurrent.CountDownLatch;

public class Lesson5 {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    final int a = finalI;
                    System.out.println(cars[finalI].getName() + " готовится");
                    Thread.sleep(500 + (int)(Math.random() * 800));
                    System.out.println(cars[finalI].getName() + " готов");
                    cdl.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cdl.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                int a = finalI;
                for (int j = 0; j < race.getStages().size(); j++) {
            race.getStages().get(j).go(cars[a]);
        }
            }).start();
        }
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
