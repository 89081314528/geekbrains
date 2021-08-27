package ru.geekbrains.lesson1.test;

public class Test1 {
    public static void main(String[] args) {
        Num<String> number = new Num<>("hiji", "jijij");
        System.out.println(number);
        number.print("oooo");
    }
}

