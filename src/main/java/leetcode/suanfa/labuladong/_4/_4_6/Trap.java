package leetcode.suanfa.labuladong._4._4_6;

public class Trap {

    //接雨水

    /**
     * 就是用一个数组表示一个条形图，问你这个条形图最多能接多少水。
     * @param nums
     * @return
     */
    public static int trap1(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int leftHeight = nums[0], rightHeight = 0;
            for (int l = 0; l <= i; l++) {
                leftHeight = Math.max(leftHeight, nums[l]);
            }
            for (int r = i; r < n; r++) {
                rightHeight = Math.max(rightHeight, nums[r]);
            }
            res += Math.min(leftHeight, rightHeight) - nums[i];
        }
        return res;
    }

    public static int trap2(int[] nums) {
        int res = 0, n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(nums[i], left[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - nums[i];
        }
        return res;
    }

    //双指针
    public static int trap3(int[] nums) {
        int res = 0;
        int n = nums.length;
        int left = 0, right = n - 1;
        int l_max = nums[0], r_max = nums[n - 1];
        while (left <= right) {
            l_max = Math.max(l_max, nums[left]);
            r_max = Math.max(r_max, nums[right]);
            if (l_max < r_max) {
                res += l_max - nums[left];
                left++;
            } else {
                res += r_max - nums[right];
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap1(nums));
        System.out.println(trap2(nums));
        System.out.println(trap3(nums));
    }
}
