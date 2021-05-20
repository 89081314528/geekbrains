package ru.geekbrains;

/**
 * FizzBuzz
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 5, 10, 15, 21, 22, 27};
        for (int i = 0; i < array.length; i++) {
            String result = "";
            if (array[i] % 3 == 0) {
                result = "Fizz";
            }
            if (array[i] % 5 == 0) {
                result = result + "Buzz";
            }
            System.out.println(result);
        }
    }
}
