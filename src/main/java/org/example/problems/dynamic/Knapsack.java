package org.example.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Входными данными является ассоциативный массив
 * "название сокровища"-"пара (вес сокровища, цена сокровища)"
 * и вместимость вашего рюкзака.
 * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
 * которые вы можете унести в рюкзаке.
 * <p>
 * Например:
 * bagPacking(
 * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 * 850
 * ) -> setOf("Кубок")
 * bagPacking(
 * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 * 450
 * ) -> emptySet()
 */
class Knapsack {

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int[] counts = {2, 1, 1};
        int capacity = 50;
        System.out.print("The maximum profit that can be obtained is : ");
        System.out.println(UnboundedKnapsack.greedyAlgorithm(capacity, values, weights));
//        System.out.println(BoundedKnapsack.iterativeDP(capacity, values, weights, counts));
        values = new int[]{2, 30};
        weights = new int[]{1, 30};
        counts = new int[]{50, 2};
        capacity = 100;
        System.out.print("The maximum profit that can be obtained is : ");
        System.out.println(UnboundedKnapsack.greedyAlgorithm(capacity, values, weights));
//        System.out.println(BoundedKnapsack.iterativeDP(capacity, values, weights, counts));
        values = new int[]{30, 1};
        weights = new int[]{50, 1};
        counts = new int[]{1, 1};
        capacity = 100;
        System.out.print("The maximum profit that can be obtained is : ");
        System.out.println(UnboundedKnapsack.greedyAlgorithm(capacity, values, weights));
//        System.out.println(BoundedKnapsack.iterativeDP(capacity, values, weights, counts));
        values = new int[]{1, 700000};
        weights = new int[]{1, 600000};
        capacity = 1000000;
        counts = new int[]{100, 2};
        System.out.print("The maximum profit that can be obtained is : ");
        System.out.println(UnboundedKnapsack.greedyAlgorithm(capacity, values, weights));
//        System.out.println(BoundedKnapsack.iterativeDP(capacity, values, weights, counts));
    }

    static class UnboundedKnapsack {

        static int startBF(int capacity, int[] values, int[] weights) {
            return bruteForce(capacity, values.length - 1, values, weights);
        }

        static int bruteForce(int capacity, int index, int[] values, int[] weights) { // O(2^N), O(N) - в стеке
            /* 	Base case of recursion with only one item.*/
            if (index == 0) {
                return (capacity / weights[0]) * values[0];
            }
            /* If the wt of an item at index is more than W it cannot be included.  */
            if (weights[index] > capacity) {
                return bruteForce(capacity, index - 1, values, weights);
            }
            /* Case 1: Solution does not include the item at the index */
            int item_not_included = bruteForce(capacity, index - 1, values, weights);
            /* Case 2: Item at index is included in solution */
            int item_included = values[index] + bruteForce(capacity - weights[index], index, values, weights);
            /*return maximum of the above cases*/
            return Math.max(item_included, item_not_included);
        }

        public static int iterativeDP(int capacity, int[] values, int[] weights) { // О(N * C), O(C)
            int[] dp = new int[capacity + 1];
            for (int w = 1; w <= capacity; w++) {
                for (int i = 0; i < values.length; i++) {
                    if (weights[i] <= w) {
                        dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]); // либо оставляем то что есть, либо берем текущий предмет и плюсуем предыдущй (по весу) оптимальный вариант
                    }
                }
            }
            return dp[capacity];
        }

        // не всегда дает оптимальное решение, но быстрый. Хорош в дробном рюкзаке
        public static int greedyAlgorithm(int capacity, int[] values, int[] weights) { // O(N log N), O(N)
            int n = values.length;
            double[] ratios = new double[n];
            for (int i = 0; i < n; i++) {
                ratios[i] = (double) values[i] / weights[i]; // заполняем массив цена/вес
            }
            int maxIndex;
            int totalValue = 0;
            while (capacity > 0) {
                maxIndex = getMaxRatioIndex(ratios);
                if (maxIndex == -1) {
                    break; // все предметы использованы
                }
                int addQuantity = Math.max(capacity / weights[maxIndex], 1);
                capacity -= addQuantity * weights[maxIndex];
                totalValue += addQuantity * values[maxIndex];
                ratios[maxIndex] = -1; // убираем использованный ц/в
            }

            return totalValue;
        }

        public static int getMaxRatioIndex(double[] ratios) { // возвращает максимальный на данные момент ц/в
            int maxIndex = -1;
            double maxRatio = 0;
            for (int i = 0; i < ratios.length; i++) {
                if (ratios[i] > maxRatio) {
                    maxRatio = ratios[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

    }

    static class ZeroOneKnapsack {

        public static int iterativeDP(int capacity, int[] values, int[] weights) { // O(N*C), O(N*C)
            int n = values.length;
            int[][] dp = new int[n + 1][capacity + 1];
            for (int i = 0; i <= n; i++) { // текущий предмет: values[i-1], weights[i-1], dp[i]
                for (int w = 0; w <= capacity; w++) {
                    if (i == 0 || w == 0) {
                        dp[i][w] = 0; // когда не рассматривается ни один предмет
                    } else if (weights[i - 1] <= w) { // можем ли взять текущий предмет
                        dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]); // что лучше - оставить текущий
                    } else {
                        dp[i][w] = dp[i - 1][w]; // если не можем взять, переносим из предыдущего прдметы
                    }
                }
            }
            return dp[n][capacity];
        }

        static int startRWM(int capacity, int[] values, int[] weights) {
            int n = values.length;
            int[][] memo = new int[n + 1][capacity + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return recursionWithMemo(values, weights, capacity, n, memo);
        }

        public static int recursionWithMemo(int[] values, int[] weights, int capacity, int index, int[][] memo) {
            if (index == 0 || capacity == 0) {
                return 0;
            }
            if (memo[index][capacity] != -1) {
                return memo[index][capacity];
            }
            if (weights[index - 1] <= capacity) {
                memo[index][capacity] = Math.max(
                        values[index - 1] + recursionWithMemo(values, weights, capacity - weights[index - 1], index - 1, memo),
                        recursionWithMemo(values, weights, capacity, index - 1, memo)
                );
            } else {
                memo[index][capacity] = recursionWithMemo(values, weights, capacity, index - 1, memo);
            }
            return memo[index][capacity];
        }

    }

    static class BoundedKnapsack {

        public static int iterativeDP(int capacity, int[] values, int[] weights, int[] counts) {
            int n = values.length;
            int[][] dp = new int[n + 1][capacity + 1];
            for (int i = 0; i <= n; i++) {
                for (int w = 0; w <= capacity; w++) {
                    if (i == 0 || w == 0) {
                        dp[i][w] = 0;
                    } else {
                        dp[i][w] = dp[i - 1][w];
                        for (int k = 1; k <= counts[i - 1] && k * weights[i - 1] <= w; k++) {
                            dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - k * weights[i - 1]] + k * values[i - 1]);
                        }
                    }
                }
            }
            return dp[n][capacity];
        }

        public static int startRWM(int capacity, int[] values, int[] weights, int[] counts) {
            int n = values.length;
            int[][] memo = new int[n + 1][capacity + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return recursionWithMemo(capacity, values, weights, counts, n, memo);
        }

        public static int recursionWithMemo(int capacity, int[] values, int[] weights, int[] counts, int index, int[][] memo) {
            if (index < 0 || capacity <= 0) {
                return 0;
            }
            if (memo[index][capacity] != -1) {
                return memo[index][capacity];
            }
            int maxTotalValue = 0;
            for (int k = 0; k <= counts[index]; k++) {
                if (k * weights[index] <= capacity) {
                    int totalValue = k * values[index] + recursionWithMemo(capacity - k * weights[index], values, weights, counts, index - 1, memo);
                    maxTotalValue = Math.max(maxTotalValue, totalValue);
                } else {
                    break;
                }
            }
            memo[index][capacity] = maxTotalValue;
            return maxTotalValue;
        }

    }

    static class ContinousKnapsack {
        static class Item {
            double value;
            double weight;
            double ratio;

            public Item(double value, double weight) {
                this.value = value;
                this.weight = weight;
                this.ratio = value / weight;
            }
        }

        public static double greedyAlgorithm(double capacity, double[] values, double[] weights) {
            int n = values.length;
            Item[] items = new Item[n];
            for (int i = 0; i < n; i++) {
                items[i] = new Item(values[i], weights[i]);
            }
            Arrays.sort(items, Comparator.comparingDouble((Item item) -> -item.ratio));
            double totalValue = 0;
            double currentWeight = 0;
            for (int i = 0; i < n; i++) {
                if (currentWeight + items[i].weight <= capacity) {
                    totalValue += items[i].value;
                    currentWeight += items[i].weight;
                } else {
                    double remainingCapacity = capacity - currentWeight;
                    totalValue += items[i].ratio * remainingCapacity;
                    break;
                }
            }
            return totalValue;
        }

        public static double iterativeDP(double capacity, double[] values, double[] weights) {
            int n = values.length;
            double[] dp = new double[n];
            for (int i = 0; i < n; i++) {
                dp[i] = values[i] / weights[i];
            }
            double totalValue = 0;
            while (capacity > 0) {
                int maxIndex = getMaxRatioIndex(dp);
                if (maxIndex == -1) {
                    break; // No items left to add
                }
                double addQuantity = Math.min(capacity / weights[maxIndex], 1.0);
                capacity -= addQuantity * weights[maxIndex];
                totalValue += addQuantity * values[maxIndex];
                dp[maxIndex] = -1; // Mark item as used
            }
            return totalValue;
        }

        public static int getMaxRatioIndex(double[] ratios) {
            int maxIndex = -1;
            double maxRatio = 0;
            for (int i = 0; i < ratios.length; i++) {
                if (ratios[i] > maxRatio) {
                    maxRatio = ratios[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

    }

}
