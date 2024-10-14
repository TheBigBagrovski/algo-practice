package org.example.contests;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NearestSmallerElements {

    public static Pair<int[], int[]> findNearestSmallerElements(int[] arr) {
        int n = arr.length;
        int[] leftNearestSmaller = new int[n];
        int[] rightNearestSmaller = new int[n];
        Arrays.fill(leftNearestSmaller, -1); // -1 означает, что нет меньшего элемента слева
        Arrays.fill(rightNearestSmaller, -1); // -1 означает, что нет меньшего элемента справа

        // Стек для поиска ближайших меньших элементов слева
        Deque<Integer> stackLeft = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stackLeft.isEmpty() && arr[stackLeft.peekLast()] >= arr[i]) {
                stackLeft.pollLast();
            }
            if (!stackLeft.isEmpty()) {
                leftNearestSmaller[i] = arr[stackLeft.peekLast()];
            }
            stackLeft.addLast(i);
        }

        // Стек для поиска ближайших меньших элементов справа
        Deque<Integer> stackRight = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stackRight.isEmpty() && arr[stackRight.peekLast()] >= arr[i]) {
                stackRight.pollLast();
            }
            if (!stackRight.isEmpty()) {
                rightNearestSmaller[i] = arr[stackRight.peekLast()];
            }
            stackRight.addLast(i);
        }

        return new Pair<>(leftNearestSmaller, rightNearestSmaller);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        Pair<int[], int[]> result = findNearestSmallerElements(arr);
        int[] leftNearestSmaller = result.getFirst();
        int[] rightNearestSmaller = result.getSecond();

        System.out.println("Left Nearest Smaller Elements: " + Arrays.toString(leftNearestSmaller));
        System.out.println("Right Nearest Smaller Elements: " + Arrays.toString(rightNearestSmaller));
    }
}

class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}

