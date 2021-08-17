package leetcode.suanfa.gongshuisanye.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _743 {

    //网络延迟时间

    /**
     * 有 n 个网络节点，标记为 1 到 n。
     *
     * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
     *
     * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    int max = 0x3f3f3f3f;
    int[] dist;
    boolean[] vis;
    int k;
    public int networkDelayTime(int[][] times, int n, int k) {
        this.k = k;
        List<int[]>[] graph = graph(times, n);
        dist = new int[n + 1];
        vis = new boolean[n + 1];
        dfs(graph);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res >= max / 2 ? -1 : res;
    }

    private void dfs(List<int[]>[] graph) {
        Arrays.fill(dist, max);
        dist[k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{k, dist[k]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            vis[poll[0]] = true;
            List<int[]> ints = graph[poll[0]];
            for (int[] anInt : ints) {
                int to = anInt[0];
                int val = anInt[1];
                if (dist[to] > dist[poll[0]] + val) {
                    dist[to] = dist[poll[0]] + val;
                    queue.add(new int[]{to, dist[to]});
                }
            }
        }
    }

    public List<int[]>[] graph(int[][] times, int n) {
        List<int[]>[] res = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            res[time[0]].add(new int[]{time[1], time[2]});
        }
        return res;
    }
}
