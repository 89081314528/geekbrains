package ru.geekbrains.lesson2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j) {
        super("Элемент в " + (i + 1) + " строке " + (j + 1) + " столбце не преобразуется в число");
    }
}
