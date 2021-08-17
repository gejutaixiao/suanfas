package leetcode.suanfa.zcybook._8;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

public class _9_2_PrintUniqueTriad {

    //不重复打印排序数组中相加和为给定值的所有三元组
    /**
     * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序三元组
     */

    public static void printUniqueTriad(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = arr[i];
            List<List<Integer>> lists = printUniquePair(arr, i + 1, k - left);
            for (List<Integer> list : lists) {
                System.out.print(left + " ");
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
        }
    }
    public static List<List<Integer>> printUniquePair(int[] arr, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int lo = start, hi = arr.length - 1;
        while (lo < hi) {
            int left = arr[lo], right = arr[hi];
            int sum = left + right;
            if (sum == k) {
                list.add(left);
                list.add(right);
                res.add(list);
                while (lo < hi && arr[lo] == left) lo++;
                while (lo < hi && arr[hi] == right) hi--;
            } else if (sum > k) {
                while (lo < hi && arr[hi] == right) hi--;
            } else {
                while (lo < hi && arr[lo] == left) lo++;
            }
            list.clear();
        }
        return res;
    }
}
