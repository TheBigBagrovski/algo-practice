package org.example;

public class NeedleInHaystack {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(solve(haystack, needle));
        haystack = "leetcode"; needle = "leeto";
        System.out.println(solve(haystack, needle));
        haystack = "mississippi"; needle = "issipi";
        System.out.println(solve(haystack, needle));
    }

    private static int solve (String haystack, String needle) {
        char[] hsArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();
        for (int i = 0; i < hsArr.length; i++) {
            char c = hsArr[i];
            if (c == nArr[0]) {
                for (int j = 0; j < nArr.length; j++) {
                    if ( i + j >= hsArr.length) {
                        return -1;
                    }
                    char c1 = nArr[j];
                    c = hsArr[i + j];
                    if (c != c1) {
                        break;
                    }
                    if (j == nArr.length - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}
