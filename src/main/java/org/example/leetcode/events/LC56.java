package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * РЕШЕНИЕ:
 * сортируем интервалы по возрастанию начал
 * проход по сортинтервалам
 * если у очередного интервала начало меньше конца предыдущего, предыдущему в конец кладем
 * максимум из концов этих двух интервалов
 * иначе кладем новый интервал
 */
public class LC56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        intervals = new int[][] {{1,4},{4,6}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public int[][] optimized(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static int[][] merge(int[][] intervals) {
        int[][] events = new int[intervals.length * 2][2];
        int i = 0;
        for (int[] interval : intervals) {
            events[i++] = new int[]{interval[0], 1};
            events[i++] = new int[]{interval[1], -1};
        }
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int state = 0;
        int start = 0, end;
        List<int[]> result = new ArrayList<>();
        for (i = 0; i < events.length; i++) {
            if (events[i][1] == 1) {
                if (state == 0) {
                    start = events[i][0];
                }
                state++;
            } else {
                if (i < events.length - 1 && events[i + 1][0] == events[i][0] && events[i + 1][1] == 1) {
                    i++;
                    continue;
                }
                state--;
                if (state == 0) {
                    end = events[i][0];
                    result.add(new int[]{start, end});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
