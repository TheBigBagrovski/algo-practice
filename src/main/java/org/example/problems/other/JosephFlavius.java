package org.example;

class JosephFlavius {

    public static void main(String[] args) {
        System.out.println(josephus(10, 2));
    }

    static int josephus(int n, int k) {
        if (n==0) {
            return 0;
        } else {
            return (josephus(n - 1, k) + k) % n;
        }
    }

}
