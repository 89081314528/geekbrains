package ru.geekbrains.lesson5;

import java.awt.event.WindowFocusListener;

/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * <p>
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class Lesson5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Guseva Vlada", "lawyer", "gv@mailbox.com", "892312300", 50000, 25),
                new Employee("Volkova Katya", "hrDirector", "vk@mailbox.com", "892312301", 80000, 36),
                new Employee("Vlasova Tanya", "commercialDirector", "vt@mailbox.com", "892312302", 300000, 31),
                new Employee("Sukhov Victor", "projectManager", "sv@mailbox.com", "892312303", 200000, 28),
                new Employee("Zabirov Timur", "director", "zt@mailbox.com", "892312304", 250000, 45)
        };
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].info();
            }
        }
    }
}
