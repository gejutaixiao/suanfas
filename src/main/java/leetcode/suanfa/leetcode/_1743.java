package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _1743 {

    public static int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        if (n == 1) {
            return new int[]{adjacentPairs[0][0], adjacentPairs[0][1]};
        }
        int[] res = new int[n + 1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] adjacentPair : adjacentPairs) {
            for (int i = 0; i < 2; i++) {
                if (set.contains(adjacentPair[i])) {
                    set.remove(adjacentPair[i]);
                } else {
                    set.add(adjacentPair[i]);
                }
            }
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        Object[] objects = set.toArray();
        res[0] = (int) objects[0];
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 2] == map.get(res[i - 1]).get(0) ? map.get(res[i - 1]).get(1) : map.get(res[i - 1]).get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ad = {{2, 1}, {3, 4}, {3, 2}};
        int[] ints = restoreArray(ad);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
