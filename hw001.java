package HW001;

import java.util.Arrays;

public class HW001 {
    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println(isSumBetween10And20(2, 6)); // false

        System.out.println(isPositive(5)); // true
        System.out.println(isPositive(-3)); // false

        printString("abcd", 5); // abcdabcdabcdabcdabcd

        System.out.println(isLeapYear(2023));
        System.out.println(Arrays.toString(createArray(8, 10)));

        int[] arrayFirst = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arrayReplaceValues(arrayFirst)));

        int[] arraySecond = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(sixMultiplyByTwo(arraySecond)));

        int[][] array = new int[4][4]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
        int x = array[2][3];

        Arrays.stream(array).map(Arrays::toString).forEach(System.out::println);
        System.out.println();
        Arrays.stream(fillDiagonal(array)).map(Arrays::toString).forEach(System.out::println);
    }

    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        if ((a + b) <= 20 && (a + b) >= 10) {
            return true;
        }
        return false;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x > 0) {
            return true;
        }
        return false;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        System.out.println(source.repeat(repeat));
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        // год является високосным, если он делится на 4, но не делится на 100, но делится на 400
        if (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    private static int[] createArray(int len, int initialValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = initialValue;
        }
        return newArray;
    }

    private static int[] arrayReplaceValues(int[] arrayFirst){
        /**
         * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
         * * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         **/
        for (int i = 0; i < arrayFirst.length; i++) {
            if (arrayFirst[i] == 0) {
                arrayFirst[i] = 1;
            }
            else {
                arrayFirst[i] = 0;
            }
        }
        return arrayFirst;
    }

    private static int[] sixMultiplyByTwo(int[] arraySecond){
        /**
         * 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         * пройти по нему циклом, и числа меньшие 6 умножить на 2;
         **/
        for (int i = 0; i < arraySecond.length; i++) {
            if (arraySecond[i] < 6) {
                arraySecond[i] *= 2;
            }
        }
        return arraySecond;
    }

    private static int[][] fillDiagonal(int[][] array) {
        /**
         * 3. Создать квадратный двумерный целочисленный массив
         * (количество строк и столбцов одинаковое),
         * и с помощью цикла(-ов) заполнить его диагональные
         * элементы единицами (можно только одну из диагоналей,
         * если обе сложно). Определить элементы одной из
         * диагоналей можно по следующему принципу: индексы
         * таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         * Также заполнить элементы побочной диагонали
         **/
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            for (int j = 0; j <array.length; j++) {
                if ((i + j) == (array.length - 1)) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }
}