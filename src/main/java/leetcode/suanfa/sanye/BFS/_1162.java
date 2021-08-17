package leetcode.suanfa.sanye.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1162 {

    //地图分析
    int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{1, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] ints : matrix) {
                int x = ints[0] + dx;
                int y = ints[1] + dy;
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) {
                    continue;
                }
                queue.add(new int[]{x, y});
                map.put(x * n + y, step + 1);
                grid[x][y] = step + 1;
                max = Math.max(step + 1, max);
            }
        }
        return max;
    }
}
