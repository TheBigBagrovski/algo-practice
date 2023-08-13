package org.example;

import java.util.Stack;

public class LC695 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,1,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,1,1},
                {0,0,1,1,1,0,0,1,1,1,0,1,0,0,1,0,0,1,0,0,0,0,1,1,1,0,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,1,1,1,1,1,0,1,0},
                {1,1,0,1,1,1,0,1,1,1,0,0,0,0,1,0,0,0,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,1,0,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1},
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,1,1},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,1,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(best(grid));

    }

    public static int best(int[][] grid) { // O(mn), O(1), supereasy
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }

    public static int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }

    public static int stillNotTheBest(int[][] grid) { // no stack overflow, O(mn), O(mn)
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();
                        int row = curr[0];
                        int col = curr[1];

                        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 1 || visited[row][col]) {
                            continue;
                        }

                        area++;
                        visited[row][col] = true;
                        stack.push(new int[]{row - 1, col});
                        stack.push(new int[]{row + 1, col});
                        stack.push(new int[]{row, col - 1});
                        stack.push(new int[]{row, col + 1});
                    }

                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public static int notTheBest(int[][] grid) { // stack overflow, O(mn), O(mn)
        int max = 0;
        max = searchIsland(grid, grid.length / 2, grid[0].length/2, max);
        return max;
    }

    private static int searchIsland(int[][] grid, int y, int x, int max) {
        if(x<0 || y<0 || y>=grid.length || x>=grid[0].length || grid[y][x] == 2) return max;
        if(grid[y][x]==1) {
            int a = countIsland(grid, y, x, 0);
            max = Math.max(a, max);
        }
        grid[y][x] = 2;
        max = Math.max(max, searchIsland(grid, y-1, x, max));
        max = Math.max(max, searchIsland(grid, y+1, x, max));
        max = Math.max(max, searchIsland(grid, y, x-1, max));
        max = Math.max(max, searchIsland(grid, y, x+1, max));
        return max;
    }

    private static int countIsland(int[][] grid,int y, int x, int area) {
        if(x<0 || y<0 || y>=grid.length || x>=grid[0].length || grid[y][x] == 2 || grid[y][x] == 0) return area;
        area++;
        grid[y][x] = 0;
        area = countIsland(grid, y+1, x, area);
        area = countIsland(grid, y-1, x, area);
        area = countIsland(grid, y, x+1, area);
        area = countIsland(grid, y, x-1, area);
        return area;
    }

}
