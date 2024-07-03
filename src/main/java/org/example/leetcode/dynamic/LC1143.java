package org.example.LeetCode.dynamicProgramming;

import static java.lang.Math.max;

/**
 * вывести длину наибольшей подпоследовательности
 */

/**
 * РЕШЕНИЯ:
 * dp O(n*m), O(n*m) -- создаем матрицу n*m, вложенным циклом проходим по строкам,
 * если символы не совпадают - берем максимум из предыдущей по одной из осей ячеек (таким образом сохраняем максимальную длину)
 * если совпадают - увеличиваем счетчик по диагонали на 1
 * конечный ответ в нижней правой ячейке матрицы
 * есть вариант боттом ап
 * -------------
 * dp O(n*m), O(n) -- создаем матрицу на m элемов, вложенным циклом проходимся по двум массивам - внешний цикл по n, внутренний по m
 * внутри цикла сравниваем элементы, если не совпадают - кладем макс между этим и предыдушим
 * если совпадают - через переменную oldValue инкрементируем предыдущее???
 */
public class LC1143 {

    public static void main(String[] args) {
        System.out.println(spaceLinear("abcd", "bc"));
        System.out.println(spaceLinear("", ""));
        System.out.println(spaceLinear("a", "b"));
        System.out.println(spaceLinear("", "b"));
        System.out.println(spaceLinear("a", ""));
        System.out.println(spaceLinear("asd", "fgh"));
        System.out.println(spaceLinear("a", "a"));
        System.out.println(spaceLinear("обсерватория", "консерватор")); //осерватор
        System.out.println(spaceLinear("abcd", "abdabcfabcd")); //осерватор
    }

    public static int spaceLinear(String text1, String text2) {// O(n*m), O(n)
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int oldValue = dp[0];
            for (int j = 1; j <= m; j++) {
                int a = dp[j];
                dp[j] = text1.charAt(i) == text2.charAt(j - 1) ? 1 + oldValue : Math.max(dp[j - 1], dp[j]);
                oldValue = a;
            }
        }
        return dp[m];
    }

    public static int bottomUpDP(String first, String second) { // O(n*m)
        int m = first.length(), n = second.length();
        int[][] lcs_matrix = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (first.charAt(i) == second.charAt(j)) {
                    lcs_matrix[i][j] = lcs_matrix[i + 1][j + 1] + 1;
                } else {
                    lcs_matrix[i][j] = max(lcs_matrix[i + 1][j], lcs_matrix[i][j + 1]);
                }
            }
        }
        return lcs_matrix[0][0];
    }

    public static int longestCommonSubsequence(String first, String second) {
        int m = first.length(), n = second.length();
        int[][] lcs_matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    lcs_matrix[i][j] = lcs_matrix[i - 1][j - 1] + 1;
                } else lcs_matrix[i][j] = max(lcs_matrix[i - 1][j], lcs_matrix[i][j - 1]);
            }
        }
        return lcs_matrix[m][n];
    }

}
