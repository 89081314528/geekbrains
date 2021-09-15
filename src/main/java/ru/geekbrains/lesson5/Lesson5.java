package ru.geekbrains.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public class Lesson5 {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT); // ждет когда все машины подготовятся к гонке
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3); // как он работает??
        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    final int a = finalI;
                    System.out.println(cars[finalI].getName() + " готовится");
                    Thread.sleep(500 + (int) (Math.random() * 800));
                    System.out.println(cars[finalI].getName() + " готов");
                    cdl.countDown();
//                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cdl.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        Semaphore smp = new Semaphore(2); // в тоннеле могут находиться одновременно 2 машины
        final CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT); // ждет завершения гонки всеми участниками и печатает
        // что гонка завершена
        final CountDownLatch cdl3 = new CountDownLatch(1); // ждет победителя и печатает только одного
        AtomicReference<Singleton> singleton = null;
        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                int a = finalI;
                for (int j = 0; j < race.getStages().size(); j++) {
                    if (race.getStages().get(j).getClass().equals(Tunnel.class)) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!");
                        race.getStages().get(j).wait(cars[a]);
                        try {
                            smp.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        race.getStages().get(j).go(cars[a]);
                        race.getStages().get(j).end(cars[a]);
                        smp.release();
                    } else {
                        race.getStages().get(j).go(cars[a]);
                        race.getStages().get(j).end(cars[a]);
                    }
                    if (j == race.getStages().size() - 1) { // здесь надо запомнить номер победителя один раз
                        singleton.set(new Singleton(a + 1));
//                        cdl3.countDown();
                    }
                }
                cdl2.countDown();
            }).start();
        }
//        try {
//            cdl3.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        cdl2.await();
        System.out.println("участник " + singleton.get().getWinner() + " победил"); // как узнать номер участника?
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
