package leetcode.suanfa.gongshuisanye.BFS;

import sun.awt.image.ImageWatched;

import java.util.*;

public class _LCP07 {

    //传递信息
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            map.putIfAbsent(ints[0], new ArrayList<>());
            map.get(ints[0]).add(ints[1]);
        }
        int step = 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (step == k) {
                    for (Integer integer : queue) {
                        if (integer == n - 1) {
                            count++;
                        }
                    }
                    return count;
                }
                Integer poll = queue.poll();
                if (map.containsKey(poll)) {
                    for (Integer integer : map.get(poll)) {
                        queue.add(integer);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
