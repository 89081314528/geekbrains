package ru.geekbrains.lesson1.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String[] array = {"cat", "dog"};
        change(array); //ковариантность - в массиве можно использовать классы-наследники, например, массив строк вместо
        // массива обджектов, в дженериках это сделать нельзя
        List<String> list = new ArrayList<>();
        list.add("pig");
        list.add("snake");
        change(list); // инвариантность - тип листа нужно использовать такой же, как в методе
        // если в методе напишем public static void change(List<Object> list) {} - не будет работать
        System.out.println(list);
        print(list);

    }
    public static void change(Object [] array) {
        Object current = array[0];
        array[0] = array[1];
        array[1] = current;
    }
    public static void change(List<String> list) { // если сделать лист обджектов, и вызвать метод с аргументом лист строк
        // программа не будет работать
        String current = list.get(0);
        String next = list.get(1);
        list.set(0,next);
        list.set(1,current);
    }
    // правильно делать параметризованные методы:
//        public static <T> void change(T [] array) {
//            T current = array[0];
//            array[0] = array[1];
//            array[1] = current;
//        }
//        public static <T> void change(List<T> list) {
//            T current = list.get(0);
//            T next = list.get(1);
//            list.set(0,next);
//            list.set(1,current);
//        }
    public static void print(List <? extends Object> list) { // wildcard позволяет добавлять в метод любой лист
        System.out.println("print");
    }
    public static <T> void print2(List<T> list) { // эти методы делают одно и то же
        System.out.println("print");
    }
    // PECS
//    producer - extends
//    consumer - super
//Collections.copy(dest, src)
//destination - super Animal, src - extends Animal

    // <T extends Animal> тут могут быть Animal и наследники
    // <T super Animal> тут могут быть Animal и суперкласс Object

//Фабричный метод - делать констуктор приватным и создавать экземпляры класса с помощью методов
static class Zoo<T> {
    private List<T> animals;

    private Zoo() {
        this.animals = new ArrayList<>();
    }

    public static <A> Zoo<A> create() {
        return new Zoo<>();  // когда мы создадим Zoo с помощью метода, А подставится в Т
    }
// в параметризованном классе нельзя создать статический метод с тем же параметром, можно с другим

// class Zoo<T>
//List<T> animals;
// Zoo <Movable> zoo = new Zoo() параметром может быть интерфейс, это значит, что все переменные в листе будут имплементировать
// этот интерфейс
}
}



