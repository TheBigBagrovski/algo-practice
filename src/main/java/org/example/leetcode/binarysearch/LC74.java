package org.example.leetcode;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 * РЕШЕНИЕ:
 * бинарный поиск по строкам, потом по столлбцам
 */
public class LC74 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 5;
        System.out.println(solve(matrix, target));
        target = -5;
        System.out.println(solve(matrix, target));
        target = 15;
        System.out.println(solve(matrix, target));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        target = 3;
        System.out.println(solve(matrix, target));
        target = 13;
        System.out.println(solve(matrix, target));
    }

    private static boolean solve(int[][] matrix, int target) { // log(n) + log(m) = log(n*m)
        int left = 0, right = matrix.length - 1, mid;
        int[] row;
        while (left < right) {
            mid = (left + right) / 2;
            if (target < matrix[mid + 1][0] && target >= matrix[mid][0]) {
                left = mid;
                break;
            }
            if (target < matrix[mid][0]) right = mid - 1;
            else left = mid + 1;
        }
        row = matrix[left];
        left = 0;
        right = row.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == row[mid]) return true;
            else if (target > row[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }


}
