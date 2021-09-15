package ru.geekbrains.lesson5;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private int winner;

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    Singleton(int winner) {
        this.winner = winner;
    }

    public Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
