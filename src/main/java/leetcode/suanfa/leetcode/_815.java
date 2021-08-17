package leetcode.suanfa.leetcode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _815 {

    //公交路线

    //给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
    //
    //例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
    //现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
    //
    //求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
    //
    //示例 1：
    //
    //输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
    //输出：2
    //解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
    /**
     * 1    2   7
     * 3    6   7
     */
    //示例 2：
    //
    //输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
    //输出：-1
    //

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int i1 : route) {
                map.putIfAbsent(i1, new LinkedList<>());
                map.get(i1).add(i);
            }
        }
        if (!map.containsKey(target)) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        int size = 0;
        int step = 1;
        for (Integer integer : map.get(source)) {
            queue.add(integer);
            vis.add(integer);
        }
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (map.get(target).contains(poll)) {
                    return step;
                }
                //poll是行号
                for (int i1 : routes[poll]) {
                    for (Integer integer : map.get(i1)) {
                        if (!vis.contains(integer)) {
                            queue.add(integer);
                            vis.add(integer);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        System.out.println(numBusesToDestination(routes, 12, 15));
        int[][] routes2 = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(numBusesToDestination(routes2, 1, 6));
    }
}
