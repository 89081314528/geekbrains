package ru.geekbrains.lesson4;

import java.util.Scanner;

public class Lesson4 {
    private static Scanner scanner = new Scanner(System.in);
    static char[][] field;
    final static int SIZE = 3;
    final static char CELL_EMPTY = '*';
    final static char CELL_X = 'X';
    final static char CELL_O = 'O';

    public static void main(String[] args) {
        field = createField();     //createField(size, EMPTY); что будет если написать без =
        printField();
        play();

    }

    public static void play() {
        for (int i = 0; i < SIZE * SIZE / 2 + 1; i++) {
            playerTurn();
            printField();
            if (playerIsWin(CELL_X)) {
                System.out.println("Победил игрок!!");
                return;
            }
            if (isDraw()) {
                System.out.println("Ничья");
                return;
            }
            computerTurn();
            printField();
            if (playerIsWin(CELL_O)) {
                System.out.println("Победил компьютер!!");
                return;
            }
            if (isDraw()) {
                System.out.println("Ничья");
                return;
            }
        }
    }

    public static boolean playerIsWin(char cell) {
        int countRow = 0;
        int countColumn = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == cell) {
                    countRow = countRow + 1;
                }
                if (field[j][i] == cell) {
                    countColumn = countColumn + 1;
                }
                if (field[i][j] == cell && i == j) {
                    countDiagonal1 = countDiagonal1 + 1;
                }
                if (field[i][j] == cell && i + j == 2) {
                    countDiagonal2 = countDiagonal2 + 1;
                }
                if (countRow == 3 || countColumn == 3 || countDiagonal1 == 3 || countDiagonal2 == 3) {
                    return true;
                }
            }
            countRow = 0;
            countColumn = 0;
        }
        return false;
    }

    public static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == CELL_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void playerTurn() {
        int x;
        int y;
        do {
            System.out.println("Ход игрока. Введите координаты клетки через пробел(сначала номер строки, потом номер колонки)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y));
        field[x][y] = CELL_X;
    }

    public static void computerTurn() {
        for (int i = 0; i < SIZE; i++) {        // в первую очередь компьютер ходит так, чтобы он выиграл
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = CELL_O;
                    if (playerIsWin(CELL_O)) {
                        System.out.println("Ход компьютера");
                        System.out.println("Выигрышный ход");
                        return;
                    } else {
                        field[i][j] = CELL_EMPTY;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {        // во вторую очередь компьютер ходит так, чтобы блокировать ход игрока
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = CELL_X;
                    if (playerIsWin(CELL_X)) {
                        System.out.println("Ход компьютера");
                        System.out.println("Блокирует игрока");
                        field[i][j] = CELL_O;
                        return;
                    } else {
                        field[i][j] = CELL_EMPTY;
                    }
                }
            }
        }

        int x;                                 // если нет возможности выиграть или не надо блокировать, ходит рандомно
        int y;
        do {
            System.out.println("Ход компьютера");
            x = (int) (Math.random() * (SIZE));
            y = (int) (Math.random() * (SIZE));
        }
        while (!isCellValid(x, y));

        field[x][y] = CELL_O;
        System.out.println("Ходит рандомно");
    }


    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < field.length && y >= 0 && y < field.length && field[x][y] == CELL_EMPTY;
    }

    public static char[][] createField() {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = CELL_EMPTY;
            }
        }
        return field;
    }

    public static void printField() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}

