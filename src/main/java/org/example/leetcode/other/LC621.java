package org.example.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
 * Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could
 * complete either one task or just be idle.
 * <p>
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same
 * letter in the array), that is that there must be at least n units of time between any two same tasks.
 * <p>
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 */
public class LC621 {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(noSorting(tasks, 2));
    }

    public static int noSorting(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0; // самый частый процесс
        int maxCount = 0; // сколько таких самых частых процессов
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        // теперь можем получить план вида    max1 max2 _ _ max1 max2 _ _ max1 max2 ...

        int partCount = max - 1; // сколько частей между самыми частыми процессами (A B _ A B _ A B - 2 части)
        int partLength = n - (maxCount - 1); // пробелов в одной части (в примере выше - 1)
        int emptySlots = partCount * partLength; // сколько пустых слотов суммарно
        int availableTasks = tasks.length - max * maxCount; // остальные доступные процессы: всего процессов минус задействованные максимумы
        int idles = Math.max(0, emptySlots - availableTasks); // если пустых слотов меньше, чем доступных процессов - простоев не будет

        return tasks.length + idles; // ответ - раскиданные процессы + простои
    }

    public static int leastInterval(char[] tasks, int n) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for (int t : tasks) {
            freq[t - 'A']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int max = freq[0];
        int idleTime = (max - 1) * n; // вычисляем количество слотов которые надо занять, A - самый частый, A _ _ A _ _ A ... - остатки
        for (int i = 1; i < freq.length && idleTime > 0; i++) {
            idleTime -= Math.min(max - 1, freq[i]); // потому что если есть процесс с такой же максимальной очередностью, мы не можем вычитать его, только на 1 меньше
        }
        idleTime = Math.max(0, idleTime); // если время простоя стало меньше 0
        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }

}
