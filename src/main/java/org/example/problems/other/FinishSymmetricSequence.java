package org.example;

public class FinishSymmetricSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1};
        System.out.println(finishSymmetricSequence(arr));
        arr = new int[]{1, 1, 2, 2, 1};
        System.out.println(finishSymmetricSequence(arr));
        arr = new int[]{0};
        System.out.println(finishSymmetricSequence(arr));
        arr = new int[]{9, 9, 9, 9, 2, 3, 3, 2};
        System.out.println(finishSymmetricSequence(arr));
        arr = new int[]{1, 2, 2, 1, 9, 2, 3, 3, 2, 1};
        System.out.println(finishSymmetricSequence(arr));
    }

    static int finishSymmetricSequence(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }
        int start = 0, end = len - 1;
        while (start < end) {
            if (arr[start] == arr[end]) {
                int i = start + 1, j = end - 1;
                int jpassed = 1;
                while (i < j) {
                    if (arr[i] != arr[j]) {
                        break;
                    }
                    i++;
                    j--;
                    jpassed++;
                }
                if (i >= j) {
                    return arr.length - jpassed - jpassed;
                }
            }
            start++;
        }
        return arr.length;
    }

}
