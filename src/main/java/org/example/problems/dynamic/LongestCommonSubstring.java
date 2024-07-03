package org.example;

public class LongestCommonSubstring {

    /**
     * Наибольшая общая подстрока.
     * Средняя
     * <p>
     * Дано две строки, например ОБСЕРВАТОРИЯ и КОНСЕРВАТОРЫ.
     * Найти их самую длинную общую подстроку -- в примере это СЕРВАТОР.
     * Если общих подстрок нет, вернуть пустую строку.
     * При сравнении подстрок, регистр символов *имеет* значение.
     * Если имеется несколько самых длинных общих подстрок одной длины,
     * вернуть ту из них, которая встречается раньше в строке first.
     */
    /**
     * РЕШЕНИЕ:
     * dp O(n*m)/O(n*m) -- Построить матрицу [a.len][b.len], вложенным циклом проходить по всем элементам строк, в случае равенства символов
     * увеличивать счетчик в нужной ячейке, опираясь на значение в предыдущей - ищем макс диагональ
     * -------------
     * dp O(n*m)/O(n)  ---
     */
    //N, M - длины первой и второй строк соответственно
    //временные затраты: O(N*M) (вложенный цикл)
    //затраты памяти: O(N*M)    (массив N*M)
    static public String longestCommonSubstring(String first, String second) {
        int[][] arr = new int[first.length() + 1][second.length() + 1];
        int maxLength = 0, maxIndex = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    if (arr[i][j] > maxLength) {
                        maxLength = arr[i][j];
                        maxIndex = i;
                    }
                }
            }
        }
        for (int i = maxIndex - maxLength; i < maxIndex; i++) result.append(first.charAt(i));
        return result.toString();
    }

}
