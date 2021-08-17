package leetcode.suanfa.labuladong._3._3_1._3_1_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    //全排列
    /**
     * 输入一组不重复的数字，输出它们的全排列
     */

    public static List<List<Integer>> premute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, res, track);
        return res;
    }
    public static void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> track) {
        if(track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            dfs(nums, res, track);
            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> lists = premute(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
