package leetcode.suanfa.sanye.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _LCP07 {

    //传递信息
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            map.putIfAbsent(ints[0], new ArrayList<>());
            map.get(ints[0]).add(ints[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int res = 0;
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (k == 0 && poll == n - 1) {
                    res++;
                }
                for (int integer : map.get(poll)) {
                    queue.add(integer);
                }
            }
            k--;
        }
        return res;
    }
}
