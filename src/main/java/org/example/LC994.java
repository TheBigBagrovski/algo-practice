package org.example;

import java.util.*;

public class LC994 {

    public static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(dfs(grid));
    }

    public static int dfs(int[][] grid) { //
        if (grid == null || grid.length == 0) return -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }

        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private static void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if (i < 0 || i >= grid.length /* out of bounds */
                || j < 0 || j >= grid[0].length /* out of bounds */
                || grid[i][j] == 0 /* empty cell */
                || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
        ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }

    public static int bfs(int[][] grid) { // O(mn), O(mn)
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0, y, x, left = 0, size, rotten, row, col;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(i * n + j);
                else if (grid[i][j] == 1) left++;
            }
        }
        if (left == 0) return 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                rotten = queue.poll();
                row = rotten / n;
                col = rotten % n;
                for (int[] dir : DIRS) {
                    y = row + dir[0];
                    x = col + dir[1];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[y][x] == 1) {
                        grid[y][x] = 2;
                        queue.offer(y * n + x);
                        left--;
                    }
                }
            }
            if (!queue.isEmpty()) {
                minutes++;
            }
        }
        return left == 0 ? minutes : -1;
    }

}
