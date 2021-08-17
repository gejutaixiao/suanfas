package leetcode.suanfa.labuladong._2._2_4._2_4_1;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    //无重叠区间

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if(start >= end) {
                count++;
                end = interval[1];
            }
        }
        return n - count;
    }
}
