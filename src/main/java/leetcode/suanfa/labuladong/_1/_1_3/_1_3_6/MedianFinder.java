package leetcode.suanfa.labuladong._1._1_3._1_3_6;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        //小顶堆
        large = new PriorityQueue<>();
        //大顶堆
        small = new PriorityQueue<>((a, b) -> b - a);
    }
    // 添加一个数字
    public void addNum(int num) {
        if(small.size() >= large.size()) {
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }
    }

    // 计算当前添加的所有数字的中位数
    public double findMedian() {
        if(small.size() > large.size()) {
            return small.peek();
        } else if(small.size() < large.size()) {
            return large.size();
        }
        return (large.peek() + small.peek()) / 2;
    }
}
