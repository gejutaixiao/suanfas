package leetcode.suanfa.labuladong._1._1_4._1_4_8_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class NSumTest {

    public static void main(String[] args) {
        Random random = new Random();
        int target = 100;
        for (int i = 0; i < 10000; i++) {
            int[] nums = new int[50];
            for (int k = 0; k < 50; k++) {
                nums[k] = random.nextInt(100);
            }
            HashSet<String> set = new HashSet<>();
            List<List<Integer>> lists = FourSum.fourSum(nums, target);
            for (List<Integer> list : lists) {
                StringBuffer sb = new StringBuffer();
                for (Integer integer : list) {
                    sb.append(integer);
                    sb.append("-");
                }
                set.add(sb.toString());
            }
            List<List<Integer>> lists1 = NSum.nSum(nums, target, 4);
            for (List<Integer> integers : lists1) {
                StringBuffer sb = new StringBuffer();
                for (Integer integer : integers) {
                    sb.append(integer);
                    sb.append("-");
                }
                String s = sb.toString();
                if (!set.contains(s)) {
                    System.err.println("出现错误！！！  36");
                } else {
                    set.remove(s);
                }
            }
            if (set.size() != 0) {
                System.err.println("出现错误！！！");
            }
        }
        System.out.println("毫无问题！！！");
    }
}
