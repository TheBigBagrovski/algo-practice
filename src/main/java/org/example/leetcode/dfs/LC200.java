package org.example.leetcode;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * РЕШЕНИЕ:
 * идем по матрице, заходим в каждую ячйеку - если это 1, то запускаем рекурсию, чтобы обнулить весь остров
 * в каждой ячейке острова пробуем пойти дальше в любую из сторон, если край карты или вода - возврат
 */
public class LC200 {

    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int counter = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    island(i, j, grid, n, m);
                }
            }
        }
        return counter;
    }

    private static void island(int i, int j, char[][] grid, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            island(i + dy[k], j + dx[k], grid, n, m);
        }
    }

}
