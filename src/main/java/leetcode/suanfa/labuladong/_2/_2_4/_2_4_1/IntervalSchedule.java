package leetcode.suanfa.labuladong._2._2_4._2_4_1;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSchedule {

    //区间调度问题
    /**
     *言归正传，本文解决一个很经典的贪心算法问题 Interval Scheduling（区间调度问题）。
     * 给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
     */

    public static int intervalSchedule(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int intervals_end = intervals[0][1];
        for (int[] interval : intervals) {
            int intervals_start = interval[0];
            if(intervals_start >= intervals_end) {
                count++;
                intervals_end = interval[1];
            }
        }
        return count;
    }
}
