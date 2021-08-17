package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _Offer57_Ⅱ {

    public static List<List<Integer>> findContinuousSequence(int target) {
        int left = 1, right = 2;
        int sum = 0;
        int mid = (target + 1) / 2;
        List<List<Integer>> res = new ArrayList<>();
        while (right <= mid) {
            sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                sum -= left++;
            } else if (sum > target) {
                left++;
            } else {
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = findContinuousSequence(15);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
