package leetcode.suanfa.leetcode;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.List;

public class _446 {

    //等差数列划分 II - 子序列
    static int res = 0;
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n - 2; i++) {
            dfs(nums, track, vis, i, i);
        }
        return res;
    }
    public static void dfs(int[] nums, LinkedList<Integer> track, boolean[] vis, int start, int index) {
        if (track.size() >= 3) {
            res = isNums(track) ? res + 1 : res;
        }
        if (index == nums.length) {
            return;
        }
        track.add(nums[index]);
        vis[index] = true;
        for (int i = start; i < nums.length; i++) {
            if (vis[i]) continue;
            dfs(nums, track, vis, start, index + 1);
        }
//        vis[index] = false;
        track.pollLast();
    }

    private static boolean isNums(LinkedList<Integer> track) {
        for (Integer integer : track) {
            System.out.print(integer);
        }
        System.out.println();
        int pre = -1;
        for (int i = 1; i < track.size(); i++) {
            if (pre == -1) {
                pre = track.get(i) - track.get(i - 1);
            } else {
                if (pre != track.get(i) - track.get(i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

}
