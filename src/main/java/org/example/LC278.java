package org.example;

public class LC278 {

    static boolean[] versions = new boolean[] {false, false, false, false, true, true};

    public static void main(String[] args) {
        System.out.println(bestSolution(versions.length));
    }

    public static boolean isBadVersion(int n) {
        return versions[n-1];
    }

    public static int bestSolution(int n) {
        int f = 1, l = n;
        while(f<=l){
            int m = f+(l-f)/2;
            if(!isBadVersion(m)){
                f = m+1;
            }else{
                l = m-1;
            }
        }
        return f;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if(right - left == 0) return mid;
                else right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
