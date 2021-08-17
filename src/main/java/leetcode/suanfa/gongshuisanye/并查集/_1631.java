package leetcode.suanfa.gongshuisanye.并查集;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _1631 {

    //最小体力消耗路径

    int N = 10009;
    int m, n;
    int[] p = new int[N];
     void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    boolean connected(int a, int b) {
         return p[find(a)] == p[find(b)];
    }
    int find(int x) {
         while (p[x] != x) {
             p[x] = find(x);
         }
         return p[x];
    }
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int start = getIndex(i, j);
                if (i + 1 < m) {
                    int end = getIndex(i + 1, j);
                    edges.add(new int[]{start, end, heights[i + 1][j] - heights[i][j]});
                }
                if (j + 1 < n) {
                    int end = getIndex(i, j + 1);
                    edges.add(new int[]{start, end, heights[i][j + 1] - heights[i][j]});
                }
            }
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        int start = 0, end = getIndex(m - 1, n - 1);
        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(edge[2], max);
            union(edge[0], edge[1]);
            if (connected(start, end)) {
                return max;
            }
        }
        return 0;
    }
    public int getIndex(int i, int j) {
         return i * n + j;
    }
}
