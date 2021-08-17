package leetcode.suanfa.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _451 {
    //451. 根据字符出现频率排序
    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     */

    public String frequencySort(String s) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) {
            nums[c - 'a']++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
        }
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            int[] str = queue.poll();
            for (int i = 0; i < str[1]; i++) {
                sb.append((char)(str[0] + 'a'));
            }
        }
        return sb.toString();
    }
}
