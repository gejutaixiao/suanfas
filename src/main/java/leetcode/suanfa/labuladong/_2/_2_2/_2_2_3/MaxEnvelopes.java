package leetcode.suanfa.labuladong._2._2_2._2_2_3;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {

    //俄罗斯套娃信封嵌套问题
    /**
     * 这道题目其实是最长递增子序列（Longes Increasing Subsequence，简写为 LIS）的一个变种，
     * 因为很显然，每次合法的嵌套是大的套小的，相当于找一个最长递增的子序列，其长度就是最多能嵌套的信封个数。
     */

    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public static int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for(int i = 0; i < n; i++) {
            //要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            //进行二分查找
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if(left == piles) {
                piles++;
            }
            //将扑克牌放到堆顶
            top[left] = poker;
        }
        return piles;
    }
}
