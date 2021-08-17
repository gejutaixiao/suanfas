package leetcode.suanfa.labuladong._3._3_1._3_1_2;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class CanPartitionKSubsets {

    //集合划分问题
    /**
     * 给你输入一个数组 nums 和一个正整数 k，请你判断 nums 是否能够被平分为元素和相同的 k 个子集。
     */

    //1.如果我们切换到这 n 个数字的视角，每个数字都要选择进入到 k 个桶中的某一个。
    public static boolean canPartitionKSubsets1(int[] nums, int k) {
        if(nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        }
        sum = sum / k;
        int[] buckets = new int[k];
        return dfs(nums, 0, sum, buckets);
    }

    //递归穷举nums中的每个数字
    public static boolean dfs(int[] nums, int start, int sum, int[] buckets) {
        //base case
        if(start == nums.length) {
            for(int i = 0; i < buckets.length; i++) {
                if(buckets[i] != sum) {
                    return false;
                }
            }
            return true;
        }
        //穷举nums[start]可能装入的桶
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] + nums[start] > sum) {
                continue;
            }
            buckets[i] += nums[start];
            if(dfs(nums, start + 1, sum, buckets)) {
                return true;
            }
            buckets[i] -= nums[start];
        }
        return false;
    }


    //2.以桶的视角进行穷举，每个桶需要遍历 nums 中的所有数字，决定是否把当前数字装进桶中；当装满一个桶之后，还要装下一个桶，直到所有桶都装满为止。
    public static boolean canPartitionKSubsets2(int[] nums, int k) {
        if(nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        }
        sum /= k;
        boolean[] used = new boolean[nums.length];
        return dfs(k, 0, 0, used, nums, sum);
    }
    //从start开始向后探查有效的nums[i]装入当前桶
    public static boolean dfs(int k, int sum, int start, boolean[] used, int[] nums, int target) {
        //base case
        if(k == 0) {
            //因为所有桶被装满
            //所以nums一定全部用完
            return true;
        }
        if(sum == target) {
            //当前桶被装满
            //递归去装下一个桶
            return dfs(k - 1, 0, 0 , used, nums, target);
        }
        for(int i = start; i < nums.length; i++) {
            if(used[i]) {
                //该数字已被使装到别的桶
                continue;
            }
            if(sum + nums[i] > target) {
                //当前桶装不下nums[i]
                continue;
            }
            //将nums[i]装入当前桶
            sum += nums[i];
            used[i] = true;
            //递归穷举下一个数字是否装入当前桶
            if(dfs(k, sum, i + 1, used, nums, target)) {
                return true;
            }
            //撤销选择
            sum -= nums[i];
            used[i] = false;
        }
        //穷举了所有数字，都无法装满当前桶
        return false;
    }
}
