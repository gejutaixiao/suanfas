package 笔试.huawei;

import java.util.LinkedList;

public class _huawei3 {

    public static int _3(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res += getInt(list, k);
                list = new LinkedList<>();
            } else {
                list.add(nums[i]);
            }
        }
        return res;
    }

    private static int getInt(LinkedList<Integer> list, int k) {
        if (list.size() < k) {
            return 0;
        }
        int[] nums = new int[list.size()];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
            max = Math.max(max, Math.abs(nums[i]));
        }
        int res = 0;
        while (max-- > 0) {
            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i]++;
                if (nums[i] > 0 && right - left + 1>= k ) {
                    res += (right - left + 1) / k;
                    left = right;
                }
                if (i == nums.length - 1) {
                    for (int j = left; j < right; j++) {
                        if (nums[j] > 0) {
                            left++;
                        }
                    }
                    res += (right - left + 1) / k;
                }
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, -1, -2, 0};
        System.out.println(_3(nums, 2));
    }

}
