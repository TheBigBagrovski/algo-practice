package org.example.leetcode;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * РЕШЕНИЕ:
 * bfs:
 * сначала в очередь закидываем коорды всех нулей, нули маркируем как посещенные
 * потом перебираем очередь, от каждого нуля из очереди шагаем во все стороны на step=1, если не вышли за груницу и не посещали эту клетку(т.е. там не ноль) ставим туда step = 1 и маркируем ее как посещенную, закидываем ее в очередь
 * таким образом на следующей волне бфса будет двигаться от новопройденных ячеек
 * повтоярем цикл, увеличивая step, пока очередь не кончится (т.е. все ячейки будут пройдены)
 * O(mn), O(mn) - может быть матрица только из нулей
 * -------------
 * дп с мемо:
 * заводим матрицу дп
 * итерируемся по ней, если встретили не ноль:
 * ставим максимально возможное расстояние (row + col)
 * если из верхней строки меньше - ставим его + 1
 * если из левого столбца меньше - ставим его + 1
 * повторяем процедуру снизу влево, только без установки в максимум
 */
public class LC542 {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,1,0,1,1}, {1,0,1,0,1}, {0,1,0,1,0},{1,0,1,0,1},{1,0,1,0,1}};
        System.out.println(Arrays.deepToString(dynamicProgramming(mat)));

    }

    public int[][] bfs(int[][] matrix) { // O(mn), O(mn) - может быть матрица только из нулей
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] temp = q.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]){
                        visited[x][y] = true;
                        matrix[x][y] = step;
                        q.add(new int[]{x,y});
                    }
                }
            }
            step++;
        }

        return matrix;
    }

    public static int[][] dynamicProgramming(int[][] mat) { // O(mn), O(mn)
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        if (rows == 1 && cols == 1) {
            return mat;
        }

        int[][] result = new int[rows][cols];
        // (rows + cols - 1) is the maximum possible distance in the matrix. Its the
        // distance been two diagonally opposite corners.
        int maxDistance = rows + cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                result[i][j] = maxDistance;
                if (i > 0) {
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                }
                if (j > 0) {
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i < rows - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if (j < cols - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }

    /* решение королей

    static class Pair{
        int a,b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,1,0,1,0}, {1,0,1,0,1}, {0,1,0,1,0},{1,0,1,0,1},{1,0,1,0,1}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));

    }

    public static int[][] updateMatrix(int[][] mat) {
        Set<Pair> left = new HashSet<>();
        Set<Pair> neighbors = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    left.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    boolean check = isNeighborToOne(mat, j, i, left);
                    if (check) neighbors.add(new Pair(i, j));
                }
            }
        }
        int distance;
        for (Pair leftEntry : left) {
            mat[leftEntry.a][leftEntry.b] = 2001;
            for (Pair entry : neighbors) {
                    distance = abs(leftEntry.a - entry.a) + abs(leftEntry.b - entry.b);
                    mat[leftEntry.a][leftEntry.b] = min(mat[leftEntry.a][leftEntry.b], distance);
            }
        }
        return mat;
    }

    public static boolean isNeighborToOne(int[][] mat, int x, int y, Set<Pair> left) {
        boolean answer = false;
        for (int i = y - 1; i <= y + 1; i += 2) {
            if (i < 0 || i >= mat.length) continue;
            if (mat[i][x] == 1) {
                left.remove(new Pair(i, x));
                answer = true;
            }
        }
        for (int j = x - 1; j <= x + 1; j += 2) {
            if (j < 0 || j >= mat[0].length) continue;
            if (mat[y][j] == 1) {
                left.remove(new Pair(y, j));
                answer = true;
            }
        }
        return answer;
    }

     */

}
