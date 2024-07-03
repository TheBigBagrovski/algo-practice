package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * найти пересечение двух массивов чисел
 * РЕШЕНИЯ:
 * сортируем массивы, двумя указателями идем по ним, если элементы равны - добавляем
 * O(nlogn), O(n)
 * ---------------
 * числа у нас до 1000, создаем массив на 1001, записываем для каждого числа - частоту
 * проходимся по этой мапе в порядке возрастания
 * O(n), O(n)
 */
public class LC350 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 1};
        int[] arr2 = new int[]{2, 2};
        System.out.println(Arrays.toString(solve(arr1, arr2)));
        arr1 = new int[]{4, 9, 5};
        arr2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solve(arr1, arr2)));
    }

    private static int[] intersect(int[] nums1, int[] nums2) { // O(nlogn), O(n)
        // Sort both the arrays first...
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // Create an array list...
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // Use two pointers i and j for the two arrays and initialize both with zero.
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            // If nums1[i] is less than nums2[j]...
            // Leave the smaller element and go to next(greater) element in nums1...
            if (nums1[i] < nums2[j]) {
                i++;
            }
            // If nums1[i] is greater than nums2[j]...
            // Go to next(greater) element in nums2 array...
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            // If both the elements intersected...
            // Add this element to arr & increment both i and j.
            else {
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        // Create a output list to store the output...
        int[] output = new int[arr.size()];
        int k = 0;
        while (k < arr.size()) {
            output[k] = arr.get(k);
            k++;
        }
        return output;
    }

    private static int[] solve(int[] arr1, int[] arr2) { // O(n), O(n)
        int[] map = new int[1001];
        for (int i : arr1) {
            map[i]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i : arr2) {
            if (map[i] != 0) {
                map[i]--;
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
