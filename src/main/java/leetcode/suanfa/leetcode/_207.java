package leetcode.suanfa.leetcode;

import java.util.List;

public class _207 {

    //课程表

    //记录一次traverse递归经过的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] vis;
    //记录图中是否有环
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = graph(numCourses, prerequisites);
        vis = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            //遍历图中所有节点
            traverse(graph, i);
        }
        //只要没有循环依赖就可以完成所有课程
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            //出现环
            hasCycle = true;
        }
        if (vis[s] || hasCycle) {
            //如果已经找到环，也不用遍历了
            return;
        }
        vis[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    public List<Integer>[] graph(int numCourses, int[][] prerequisites) {
        List<Integer>[] res = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[1], end = prerequisite[0];
            res[start].add(end);
        }
        return res;
    }
}
