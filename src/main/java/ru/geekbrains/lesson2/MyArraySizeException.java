package ru.geekbrains.lesson2;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(int length) {
        super("Размер массива должен быть " + length + " x " + length);
    }
}
