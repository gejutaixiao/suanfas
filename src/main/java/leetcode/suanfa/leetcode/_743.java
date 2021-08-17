package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _743 {

    //网络延迟时间

    // 1.Floyd（邻接矩阵）
    //跑一遍Floyd，可以得到【从任意起点出发，到达任意终点的最短距离】

    int MAX = 0x3f3f3f3f;
    public int networkDelayTime1(int[][] times, int n, int k) {

        //定义图，w[a][b] = c，表示从a到b需要花费c时间
        int[][] w = new int[n + 1][n + 1];
        //初始化图
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : MAX;
            }
        }
        //对图赋值
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            w[a][b] = c;
        }
        //floyd算法
        floyd(w);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, w[k][i]);
        }
        return res >= MAX / 2 ? -1 : res;
    }
    //floyd流程
    //枚举中转点 -> 枚举起点 -> 枚举终点 -> 松弛操作
    public void floyd(int[][] w) {
        int n = w.length;
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }

    // 2.朴素Dijkstra（邻接矩阵）
    public int networkDelayTime2(int[][] times, int n, int k) {
        int[][] w = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        int max = 0x3f3f3f3f;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : max;
            }
        }
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            w[a][b] = c;
        }
        dijkstra(w, dist, vis, k);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res >= max / 2 ? -1 : res;
    }

    private void dijkstra(int[][] w, int[] dist, boolean[] vis, int k) {
        Arrays.fill(vis, false);
        Arrays.fill(dist, MAX);
        dist[k] = 0;
        int n = vis.length;
        for (int p = 1; p < n; p++) {
            int t = -1;
            //找到没有别访问过且所需时间最小的t
            for (int i = 1; i < n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) {
                    t = i;
                }
            }
            vis[t] = true;
            for (int i = 1; i < n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }
    }

    // 3.堆优化 Dijkstra（邻接表）
    int N = 110, M = 6010;
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    int index;
    public int networkDelayTime3(int[][] times, int n, int k) {
        boolean[] vis = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(he, -1);
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            add(a, b, c);
        }
        dijkstra(dist, vis, k);
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dist[i]);
        }
        return res >= MAX / 2 ? -1 : res;
    }
    void add(int a, int b, int c) {
        e[index] = b;
        ne[index] = he[a];
        he[a] = index;
        w[index] = c;
        index++;
    }
    public void dijkstra(int[] dist, boolean[] vis, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, MAX);
        Arrays.fill(vis, false);
        dist[k] = 0;
        queue.add(new int[]{k, dist[k]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int id = poll[0];
            if (vis[id]) continue;
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[id] + w[i]) {
                    dist[j] = dist[id] + w[j];
                    queue.add(new int[]{j, dist[j]});
                }
            }
        }
    }

    // 4.Bellman Ford（类 & 邻接表）
    class Edge {
        int a;
        int b;
        int c;
        public Edge(int _a, int _b, int _c) {
            a = _a;
            b = _b;
            c = _c;
        }
    }
    public int networkDelayTime4(int[][] times, int n, int k) {
        List<Edge> list = new ArrayList<>();
        int[] dist = new int[n + 1];
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            list.add(new Edge(a, b, c));
        }
        bf(list, dist, k);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res >= MAX / 2 ? -1 : res;
    }

    private void bf(List<Edge> list, int[] dist, int k) {
        Arrays.fill(dist, MAX);
        dist[k] = 0;
        for (int p = 1; p < dist.length; p++) {
            int[] prev = dist.clone();
            for (Edge edge : list) {
                int a = edge.a, b = edge.b, c = edge.c;
                dist[b] = Math.min(dist[b], prev[a] + c);
            }
        }
    }
}
