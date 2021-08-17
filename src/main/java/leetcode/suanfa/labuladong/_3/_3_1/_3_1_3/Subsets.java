package leetcode.suanfa.labuladong._3._3_1._3_1_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    //子集
    /**
     * 问题很简单，输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集。
     */

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> sunsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, 0, track);
        return res;
    }
    public static void dfs(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for(int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            dfs(nums, i + 1, track);
            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> lists = sunsets(nums);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
