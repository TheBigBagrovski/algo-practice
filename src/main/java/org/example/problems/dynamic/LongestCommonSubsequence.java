package org.example;

import static java.lang.Math.max;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        longestCommonSubsequence("abcd", "bc");
    }

    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     * <p>
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    /**
     * РЕШЕНИЯ:
     * dp O(n*m), O(n*m) - матрица m*n, проходимся вложенным списком по 2 строкам,
     * если символы не совпадают - берем макс из предыдущей вертикали/горизонтали
     * если совпадают - увеличиваем по диагонали
     * восстановление ответа: идем с конца, сравнивая символы в строках
     * если они равны, добавляем символ в ответ, оба указателя декрементируем
     * иначе если в предыдущей колонке число больеш чем в столбце - уменьшаем указатель m
     * иначе уменьшаем указатель n
     *
     * ЛИНЕЙНОЕ ПО ПАМЯТИ???
     */
    //временные затраты: O(m*n)
    //затраты памяти: O(m*n)
    public static String longestCommonSubsequence(String first, String second) {
        int m = first.length(), n = second.length();
        int[][] lcs_matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    lcs_matrix[i][j] = lcs_matrix[i - 1][j - 1] + 1;
                else lcs_matrix[i][j] = max(lcs_matrix[i - 1][j], lcs_matrix[i][j - 1]);
            }
        }
        int index = lcs_matrix[m][n];
        char[] answer = new char[index];
        while (m > 0 && n > 0) {  // abcd   bc
            if (first.charAt(m - 1) == second.charAt(n - 1)) {
                answer[index - 1] = first.charAt(m - 1);
                m--;
                n--;
                index--;
            } else if (lcs_matrix[m - 1][n] > lcs_matrix[m][n - 1]) m--;
            else n--;
        }
        return new String(answer);
    }

}
