package org.example.leetcode;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * РЕШЕНИЕ:
 * развернуть столбцы и транспонировать
 */
public class LC48 {

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void solve(int[][] matrix) {
        int n = matrix[0].length;
        //Column Reverse
        for(int i = 0; i < n; i++){
            int a = 0;
            int b = n-1;
            while(a <= b){
                int temp = matrix[a][i];
                matrix[a][i] = matrix[b][i];
                matrix[b][i] = temp;
                a++;
                b--;
            }

        }

        //Transpose
        for(int i = 0; i < n; i++){
            for(int j =i+1; j< n; j++){
                int temp =  matrix[i][j];
                matrix[i][j] =  matrix[j][i];;
                matrix[j][i] = temp;
            }
        }

    }

}
