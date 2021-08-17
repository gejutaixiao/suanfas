package leetcode.suanfa.labuladong._3._3_4._3_4_3;

import java.util.PriorityQueue;

public class FindKthLargest {

    //数组中第k大的元素
    /**
     * 原始题目很简单，给你输入一个无序的数组 nums 和一个正整数 k，让你计算 nums 中第 k 大的元素。
     * 那你肯定说，给 nums 数组排个序，然后取第 k 个元素，也就是 nums[k-1]，不就行了吗？
     * 当然可以，但是排序时间复杂度是 O(NlogN)，其中 N 表示数组 nums 的长度。
     * 我们就想要第 k 大的元素，却给整个数组排序，有点杀鸡用牛刀的感觉，所以这里就有一些小技巧了，可以把时间复杂度降低到 O(NlogK) 甚至是 O(N)，下面我们就来具体讲讲。
     */

    public static int findKthLargest (int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
