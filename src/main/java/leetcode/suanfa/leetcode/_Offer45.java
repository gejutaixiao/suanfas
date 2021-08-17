package leetcode.suanfa.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _Offer45 {

    //把数组排成最小的数
    /**
     * 输入一个非负整数数组，把数组所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public static String minNumber(int[] nums) {
        int n = nums.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));
    }
}
