package org.example;

import java.util.Arrays;
import java.util.Collections;

public class LC198 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1};
        System.out.println(solve(array));
        array = new int[]{2,7,9,3,1};
        System.out.println(solve(array));
        array = new int[]{1,1,7,1,1,7,1,1,7,1,1,7,1,1};
        System.out.println(solve(array));
        array = new int[]{1,2};
        System.out.println(solve(array));
        array = new int[]{1,3,1};
        System.out.println(solve(array));
        array = new int[]{1,2,3,4,5};
        System.out.println(solve(array));
    }

    private static int solve(int[] array) { // O(n), O(1)
        int max = Arrays.stream(array).max().getAsInt();
        if (array.length < 3) {
            return max;
        }
        int localmax;
        localmax = array[0];

        for (int i = 2; i < array.length; i++) {
            array[i] += localmax;
            if(array[i] > max) max = array[i];
            if(array[i-1] > localmax) localmax = array[i-1];
        }
        return max;
    }

}
