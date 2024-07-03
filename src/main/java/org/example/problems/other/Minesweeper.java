package org.example;

import java.util.Arrays;

public class Minesweeper {

    public static void main(String[] args) {
        int n = 8, m = 8;
        int[][] mines = new int[][]{{0, 0}, {0, 1}, {5, 5}, {7, 7}};
        System.out.println(Arrays.deepToString(setMines(n, m, mines)));
    }

    static int[][] setMines(int n, int m, int[][] mines) {
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] field = new int[n][m];
        int[][] ext = new int[n + 2][m + 2];
        for (int[] mine : mines) {
            for (int k = 0; k < 8; k++) {
                ext[mine[0] + 1 + dy[k]][mine[1] + 1 + dx[k]]++;
            }
        }
        for (int[] mine : mines) {
            ext[mine[0] + 1][mine[1] + 1] = -1;
        }
        for (int i = 0; i < 8; i++) {
            int[] newArray = Arrays.copyOfRange(ext[i + 1], 1, 9);
            field[i] = newArray;
        }
        return field;
    }

}
