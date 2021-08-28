package ru.geekbrains;

public class Apple extends Fruit{
    double weight = 1; // как использовать это значение в Box

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "apple";
    }
}
