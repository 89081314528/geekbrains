package ru.geekbrains.lesson1.test;

public class Test1 <T> {
    public static void main(String[] args) {
        Num<String> number = new Num<>("joijoi", "jijijij");

    }
}

    class Num <T> {
        public final T one;
        public final String two;

        public Num(T one, String two) {
            this.one = one;
            this.two = two;
        }

}
