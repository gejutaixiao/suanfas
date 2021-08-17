package leetcode.suanfa.gongshuisanye.BFS;

import sun.awt.image.ImageWatched;

import java.util.*;

public class _1162 {


    // 1.单源bfs，超时。
    int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int max = -1;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, bfs(grid, i, j, m, n));
                }
            }
        }
        return max;
    }
    public int bfs(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        HashSet<String> vis = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                if (grid[poll[0]][poll[1]] == 1) {
                    return step;
                }
                for (int p = 0; p < 4; p++) {
                    int x = matrix[p][0] + poll[0];
                    int y = matrix[p][1] + poll[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || vis.contains(x + "," + y)) {
                        continue;
                    }
                    queue.add(new int[]{x, y});
                    vis.add(x + "," + y);
                }
            }
            step++;
        }
        return -1;
    }

    // 2.多源BFS
    public int maxDistance2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] ints : matrix) {
                int x = dx + ints[0];
                int y = dy + ints[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (grid[x][y] != 0) continue;
                grid[x][y] = step + 1;
                queue.add(new int[]{x, y});
                map.put(x * n + y, step + 1);
                res = Math.max(res, step + 1);
            }

        }
        return res;
    }

    public int maxDistance3(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int dx = poll[0], dy = poll[1];
            int step = Math.max(grid[dx][dy], 0);
            for (int[] ints : matrix) {
                int x = dx + ints[0], y = dy + ints[1];
                if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 0) {
                    continue;
                }
                queue.add(new int[]{x, y});
                grid[x][y] = step + 1;
                res = Math.max(res, step + 1);
            }
        }
        return res;
    }
}
