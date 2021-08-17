package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _797 {

    //所有可能的路径
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.add(i);
        int n = graph.length;
        if (i == n - 1) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int i1 : graph[i]) {
            traverse(graph, i1, path);
        }
        path.removeLast();
    }

}
