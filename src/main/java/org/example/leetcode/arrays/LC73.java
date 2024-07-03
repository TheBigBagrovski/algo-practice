package org.example.leetcode;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * РЕШЕНИЕ:
 * проходимся по матрицу, если встречаем 0 - тыкаем 0 в начало стобца и строки - флажок что их надо будет обнулить
 * отдельно: если в нулевом столбце находим 0, то переменную фр - в тру, потом надо будет обнулить первую строку
 * аналогично с первым столбцом
 * О(н*н),О(1)
 */
public class LC73 {

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {{1, 1, 1}, {1,0,1}, {1,1,1}};
//        System.out.println(Arrays.deepToString(solve(matrix)));
        int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(Arrays.deepToString(solve(matrix)));
    }

    private static int[][] solve(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }

}
