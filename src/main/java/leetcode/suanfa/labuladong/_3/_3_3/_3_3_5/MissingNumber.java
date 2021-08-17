package leetcode.suanfa.labuladong._3._3_3._3_3_5;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {

    //找到所有数组中消失的数字
    /**
     * 给一个长度为 n 的数组，其索引应该在 [0,n)，但是现在你要装进去 n + 1 个元素 [0,n]，那么肯定有一个元素装不下嘛，请你找出这个缺失的元素。
     * 这道题不难的，我们应该很容易想到，把这个数组排个序，然后遍历一遍，不就很容易找到缺失的那个元素了吗？
     * 或者说，借助数据结构的特性，用一个 HashSet 把数组里出现的数字都储存下来，再遍历 [0,n] 之间的数字，去 HashSet 中查询，也可以很容易查出那个缺失的元素。
     * 排序解法的时间复杂度是 O(NlogN)，HashSet 的解法时间复杂度是 O(N)，但是还需要 O(N) 的空间复杂度存储 HashSet。
     * 第三种方法是位运算。
     * 对于异或运算（^），我们知道它有一个特殊性质：一个数和它本身做异或运算结果为 0，一个数和 0 做异或运算还是它本身。
     */


    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                res = i;
                break;
            }
        }
        return res;
    }


    public static int missingNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public static int missingNumber4(int[] nums) {
        int n = nums.length;
        int sum1 = (0 + n) * (n + 1) / 2;
        int sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }
        return sum1 - sum2;
    }

    public static int missingNumber5(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res += i - nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
        System.out.println(missingNumber4(nums));
        System.out.println(missingNumber5(nums));
    }
}
