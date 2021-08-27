package ru.geekbrains.lesson1.test;

public class Num <T>{ // параметр может быть в поле, в переменной, в методе и т. д.
    final String one;
    final String two;

    public Num(String one, String two) {
        this.one = one;
        this.two = two;
    }
public void print(T t) {
    System.out.println(t);
}
    public String toString(){
        return "one = " + one + " two = " + two;
    }
}
