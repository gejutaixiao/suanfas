package leetcode.suanfa.labuladong._3._3_1._3_1_3;

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Permute {

    //全排列
    /**
     * 输入一个不包含重复数字的数组 nums，返回这些数字的全部排列。
     */

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, track);
        return res;
    }
    public static void dfs(int[] nums, LinkedList<Integer> track) {
        if(track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            dfs(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
