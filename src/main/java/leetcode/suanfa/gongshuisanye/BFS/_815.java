package leetcode.suanfa.gongshuisanye.BFS;

import leetcode.suanfa.labuladong._3._3_3._3_3_2.TrailingZeroes;

import java.util.*;

public class _815 {

    // 815.公交路线
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i< routes.length; i++) {
            for (int i1 : routes[i]) {
                map.putIfAbsent(i1, new LinkedList<>());
                map.get(i1).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        for (Integer integer : map.get(source)) {
            queue.add(integer);
            vis.add(integer);
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (map.get(target).contains(poll)) {
                    return step;
                }
                for (int i1 : routes[poll]) {
                    for (Integer integer : map.get(i1)) {
                        if (!vis.contains(integer)) {
                            vis.add(integer);
                            queue.add(integer);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
