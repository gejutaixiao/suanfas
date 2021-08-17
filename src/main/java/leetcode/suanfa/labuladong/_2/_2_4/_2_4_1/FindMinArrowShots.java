package leetcode.suanfa.labuladong._2._2_4._2_4_1;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

    //用最少数量的箭引爆气球
    public static int findMinArrowShots(int[][] intervals) {
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
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if(start > end) {
                count++;
                end = interval[1];
            }
        }
        return count;
    }
}
