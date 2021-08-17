package leetcode.suanfa.labuladong._1._1_4._1_4_2;

import sun.plugin2.message.GetAppletMessage;

public class SplitArray {

    //分割数组的最大值
    /**
     * 给定一个非负整数数组和一个整数m，你需要将这个数组分割成m个非空连续的子数组。
     * 设计一个算法，使得这m个数组的各自和的最大值最小
     */

    public int splitArray(int[] nums, int m) {
        int left = getMax(nums), right = getSums(nums) + 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int n = split(nums, mid);
            //向左边界搜索
            if(n == m) {
                right = mid;
            } else if(n < m) {  //最大子数组和上限高了，减小一些
                right = mid;
            } else if(m > n) {  //最大子数组和上限低了，增加一些
                left = mid + 1;
            }
        }
        return left;
    }
    public int getMax(int[] nums) {
        int max = 0;
        for(int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }
    public int getSums(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    public int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;
        for(int n : nums) {
            if(sum + n > max) {
                sum = n;
                count++;
            } else {
                sum += n;
            }
        }
        return count;
    }
}
