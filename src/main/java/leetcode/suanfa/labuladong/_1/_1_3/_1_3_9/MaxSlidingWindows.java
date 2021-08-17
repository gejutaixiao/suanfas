package leetcode.suanfa.labuladong._1._1_3._1_3_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxSlidingWindows {

    //滑动窗口最大值
    /**
     * 给你输入一个数组 nums 和一个正整数 k，有一个大小为 k 的窗口在 nums 上从左至右滑动，请你输出每次窗口中 k 个元素的最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i < k - 1) {
                //先加入前k - 1个元素
                queue.push(nums[i]);
            } else {
                //窗口向前滑动，加入新数字
                queue.push(nums[i]);
                //记录当前窗口的最大值
                list.add(queue.max());
                //移除旧数字
                queue.pop(i - k + 1);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class MonotonicQueue {
    LinkedList<Integer> list = new LinkedList<>();
    public void push(int num) {
        while(!list.isEmpty() && list.peek() < num) {
            list.pollLast();
        }
        list.addLast(num);
    }
    public int max() {
        return list.getFirst();
    }
    public void pop(int n) {
        if(n == list.getFirst()) {
            list.removeFirst();
        }
    }
}
