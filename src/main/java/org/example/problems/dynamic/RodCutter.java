package org.example.problems.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;



public class RodCutter {
    private static Map<Integer, Cut> storage = new HashMap<>();
    private static Map<Integer, Integer> cost = Map.of(
            1, 1,
            2, 5,
            3, 9,
            4, 9,
            5, 10,
            6, 17,
            7, 17,
            8, 20,
            9, 24
    );

    static class Cut {
        private int cost;
        private List<Integer> length;

        Cut(int cost, List<Integer> length) {
            this.cost = cost;
            this.length = length;
        }

        int getCost() {
            return cost;
        }

        List<Integer> getLength() {
            return length;
        }

        Cut add(Cut cut) {
            List<Integer> newLength = new ArrayList<>(this.length);
            newLength.addAll(cut.length);
            return new Cut(this.cost + cut.cost, newLength);
        }
    }

    private static Cut cutRod(int n, IntFunction<Integer> costFunction) {
        if (storage.containsKey(n)) {
            return storage.get(n);
        }

        Cut best = new Cut(costFunction.apply(n), List.of(n));
        for (int first = 1; first < n; first++) {
            Cut current = new Cut(costFunction.apply(first), List.of(first)).add(cutRod(n - first, costFunction));
            if (current.getCost() > best.getCost()) {
                best = current;
            }
        }
        storage.put(n, best);
        return best;
    }

    public static void main(String[] args) {
        System.out.println(cutRod(20, cost::get));
        System.out.println(cutRod(10, cost::get));
        System.out.println(cutRod(8, cost::get));
    }
}
