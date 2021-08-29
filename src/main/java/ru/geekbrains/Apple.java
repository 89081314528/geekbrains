package ru.geekbrains;

public class Apple extends Fruit{
    public double getWeight() { // нет поля, поэтому не расходуется память
        return 1;
    }

    public String toString() {
        return "apple";
    }
}
