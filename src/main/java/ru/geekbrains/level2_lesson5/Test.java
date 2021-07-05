package ru.geekbrains.level2_lesson5;

public class Test {
    public static void main(String[] args) {
        float[] arr = new float[10];
//        for (float v : arr) {
//            v = 1.0f;
//        }
        for (int i = 0; i < 10; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
