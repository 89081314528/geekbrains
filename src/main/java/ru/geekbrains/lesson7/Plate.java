package ru.geekbrains.lesson7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (n > food) {
            System.out.println("В тарелке нет столько еды");
            return;
        } else {
            food = food - n;
        }
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int n) {
        food = food + n;
    }

}