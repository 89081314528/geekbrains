package ru.geekbrains.lesson2;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива
 * другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
 * текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой
 * именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
 * MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход
 * корректный массив).
 * Заметка: Для преобразования строки к числу используйте статический метод класса Integer: Integer.parseInt
 * (сюда_подать_строку);
 * Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано),
 * то будет сгенерировано исключение NumberFormatException.
 */
public class Lesson2 {
    public static void main(String[] args) {
        String[][] arr = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "зз"}};
        try {
            System.out.println(sum(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static Integer sum(String[][] arr) {
        Integer sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new MyArraySizeException("Длина массива должна быть 4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Длина массива должна быть 4");
                }
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент в " + (i + 1) + " строке " + (j + 1) + " столбце не преобразуется в число");
                }
            }
        }
        return sum;
    }
}
