package ru.geekbrains.level2_lesson5;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * <p>
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * <p>
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * <p>
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 * <p>
 * Пример обратной склейки:
 * <p>
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 * <p>
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * <p>
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * <p>
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */
public class Lesson5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        for (float v : arr) {
            v = 1;

        }
        method1(arr);
        method2(arr);
    }

    private static void method1(float[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Время выполнения метода1 (без использования потоков) " + (finishTime - startTime));
    }

    private static void method2(float[] arr) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        //не нужна синхронизация? потоки будут отдельно работать каждый со своим массивом?
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long finishTime = System.currentTimeMillis();
        System.out.println("Время выполнения метода2 (с использованием потоков) " + (finishTime - startTime));
    }
}
