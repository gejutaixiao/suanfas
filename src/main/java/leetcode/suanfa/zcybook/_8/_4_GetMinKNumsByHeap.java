package leetcode.suanfa.zcybook._8;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class _4_GetMinKNumsByHeap {

    //找到无序数组中最小的K个数

    /**
     * 定义的优先队列是小根堆，即获得的是这些数据里面的最大值，即正金字塔，获得的是塔底
     * 大根堆，获得的是这些数据里面的最小值，即倒金字塔，获得的是塔底
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] getMinKNumsByHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (queue.peek() > num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 1, 6, 2};
        int[] minKNumsByHeap = getMinKNumsByHeap(nums, 3);
        for (int s : minKNumsByHeap) {
            System.out.println(s);
        }
    }
}


