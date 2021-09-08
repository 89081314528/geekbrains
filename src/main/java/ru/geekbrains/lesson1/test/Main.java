package ru.geekbrains.lesson1.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt"));
//        String str;
//        for (int i = 0; i < 10; i++) {
//            str = "i";
//            writer.write(str);
//        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("demo.txt"))) {
            for (int i = 0; i < 20; i++) {
                writer.write("Java\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
