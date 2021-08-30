package ru.geekbrains;

public class Apple extends Fruit{
    public static final double WEIGHT = 1;
    public double getWeight() { // нет поля, поэтому не расходуется память
        return WEIGHT;
    }

    public String toString() {
        return "apple";
    }
}
