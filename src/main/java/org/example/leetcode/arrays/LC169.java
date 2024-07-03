package org.example.leetcode;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * РЕШЕНИЯ:
 * алгоритм голосования мура:
 * заводим текущий элемент и счетчик, если текущий элемент встретился еще раз, увеличиваем счетчик
 * если встретился другой - уменьшаем
 * если счетчик 0 - обновляем текущий
 * поскольку наш элемент встречается на 1 раз да больше, на нем счетчик остановится в конце
 * О(н), О(1)
 * ----------------
 * битный
 * заводим массив на 32, счетчик под каждый бит
 * проходим по массиву, считаем единицы
 * единицы в ответе в тех битах, которые встречались чаще n/2 раз
 * О(н), О(1)
 */
public class LC169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,2,2,1,1,1}));
        System.out.println(majorityElement(new int[] {2,2,2,2,1,1,1,2,1,2,1,1,1}));
    }

    public static int majorityElement(int[] nums) { // Moore Voting Algo
        int current = nums[0], counter = 0;
        for (int num : nums) {
            if (counter == 0) {
                current = num;
            }
            if (current == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return current;
    }

    // Bit manipulation
    public int bitwise(int[] nums) { // 2,1,2,3,2: 010, 001, 010, 011, 010 -> 042 -> 0 > (5 / 2) = 0, 4 > (5 / 2) = 1, 2 > (5/2) = 0 => 010 => 2 ---- GENIUS
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

}
