package leetcode.suanfa.zcybook._8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6_2_PrintHalfMajor {

    //在数组中找到出现次数大于N/K的数
    /**
     * 给定一个整型数组arr，再给定一个整数K，打印出所有出现次数大于N/K的数，如果没有这样的数，打印提示信息
     */

    /**
     * 一次在数组中删除K个不同的数，不停地删除，直到剩下的数的种类不足K，那么，如果某些数在数组中出现次数大于N/K，则这些数最后一定会被剩下来。
     * 只要立K-1个候选，然后有K-1个times统计即可
     * @param arr
     */
    public static void printHalfMajor(int[] arr, int K) {
        if (K < 2) {
            System.out.println("the value of K is invalid");
            return;
        }
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (cands.containsKey(num)) {
                cands.put(num, cands.get(num) + 1);
            } else {
                if (cands.size() == K - 1) {
                    //cands中所有的数据数量减一
                    allCandsMinusOne(cands);
                } else {
                    cands.put(num, 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        boolean printFlag = false;
        for (Map.Entry<Integer, Integer> entry : reals.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > arr.length / K) {
                printFlag = true;
                System.out.println(key + " ");
            }
        }
        System.out.println(printFlag ? "" : "no such number.");
    }

    private static void allCandsMinusOne(HashMap<Integer, Integer> cands) {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cands.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                list.add(key);
            }
            cands.put(key, value - 1);
        }
        for (Integer integer : list) {
            cands.remove(integer);
        }
    }

    private static HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                reals.put(arr[i], reals.getOrDefault(arr[i], 0) + 1);
            }
        }
        return reals;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 5, 5, 6, 7, 8};
        printHalfMajor(arr, 3);
    }

    /**
     * 更改题目定义找出数组中出现次数大于K的数字
     */
}
