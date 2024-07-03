package org.example.leetcode.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * РЕШЕНИЕ:
 * не забываем завести дх и ду перед проходом, преобразуем искомую строку в массив символов для сравнения
 * в дфсе передаем текущий индекс искомого символа, текущие коорды
 * помечаем текущую клектку *
 * пробуем дфсом пройти на все 4 стороны
 * когда вернулись из дфса возвращаем исхоный символ
 * O(m*n*4^L), O(1)
 */
public class LC79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    private static final int[] dx = new int[]{0, -1, 1, 0};
    private static final int[] dy = new int[]{1, 0, 0, -1};

    public static boolean exist(char[][] board, String word) { // OPTIMIZED // O(m*n*4^L), O(1)
        int n = board.length;
        int m = board[0].length;
        char[] wordChars = word.toCharArray(); // вместо билдера
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == wordChars[0]) {
                    if (dfs(board, wordChars, 0, j, i, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] wordChars, int index, int x, int y, int n, int m) {
        if (index == wordChars.length) { // вместо сравнения строки
            return true; // Found the entire word
        }
        if (x < 0 || x >= m || y < 0 || y >= n || board[y][x] != wordChars[index]) {
            return false; // Out of bounds or doesn't match the current character
        }
        char originalChar = board[y][x];
        board[y][x] = '*'; // Mark the cell as visited // вместо boolean[][]
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (dfs(board, wordChars, index + 1, nx, ny, n, m)) {
                return true; // If any direction returns true, we found the word
            }
        }
        board[y][x] = originalChar; // Restore the original character
        return false;
    }



    public static boolean bad(char[][] board, String word) { // O(m*n*4^L) - проход по всем клеткам и просмотр 4 соседей - экспоненциальный рост
        int n = board.length, m = board[0].length;  // O(m*n + L) - память, т.к. used и билдер
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[n][m];
                    if (backtrack(n, m, used, board, word, new StringBuilder(), 0, j, i)) return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int n, int m, boolean[][] used, char[][] board, String word, StringBuilder current, int needIndex, int x, int y) {
        current.append(board[y][x]);
        if (current.toString().equals(word)) return true;
        used[y][x] = true;
        needIndex++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !used[ny][nx] && board[ny][nx] == word.charAt(needIndex)) {
                if (backtrack(n, m, used, board, word, current, needIndex, nx, ny)) return true;
            }
        }
        used[y][x] = false;
        current.delete(current.length() - 1, current.length());
        return false;
    }

}
