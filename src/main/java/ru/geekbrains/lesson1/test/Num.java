package ru.geekbrains.lesson1.test;

public class Num <T>{
    final T one;
    final String two;

    public Num(T one, String two) {
        this.one = one;
        this.two = two;
    }

    public String toString(){
        return "one = " + one + " two = " + two;
    }
}
