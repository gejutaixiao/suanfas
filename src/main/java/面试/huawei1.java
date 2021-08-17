package 面试;

public class huawei1 {

    static int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(grid, i, j, m, n));
            }
        }
        return max;
    }
    public static int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= m || grid[i][j] == 0) {
            return 0;
        }
        int res = grid[i][j];
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = matrix[k][0] + i;
            int y = matrix[k][1] + j;
            res += dfs(grid, x, y, m, n);
        }
        return res;
    }
}
