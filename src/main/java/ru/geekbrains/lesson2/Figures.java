package ru.geekbrains.lesson2;

/**
 Рисунок 1
 * * * * * *
 *         *
 *         *
 *         *
 *         *
 * * * * * *
 Рисунок 2
 * * * * * *
 * *       *
 *   *     *
 *     *   *
 *       * *
 * * * * * *
 Рисунок 3
 *
 * *
 *   *
 *     *
 *       *
 * * * * * *
 Рисунок 4
 * * * * * *
 * * * * * *
 * *     * *
 * *     * *
 * * * * * *
 * * * * * *
 Рисунок 5
 * * * *
 * * * *
 * * * * * *
 * * * * * *
     * * * *
     * * * *
 */
public class Figures {
    public static void main(String[] args) {
        figure1();
        System.out.println();
        figure2();
        System.out.println();
        figure3();
        System.out.println();
        figure4();
        System.out.println();
        figure5();
    }
    public static void figure1() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void figure2() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5 || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void figure3() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 5 || j == 0 || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void figure4() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 2 || i > 3 || j < 2 || j > 3) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void figure5() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 2 && j < 4) {
                    System.out.print("* ");
                } else
                if ( i >= 2 && i < 4) {
                    System.out.print("* ");
                } else
                if ( i > 3 && j > 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
