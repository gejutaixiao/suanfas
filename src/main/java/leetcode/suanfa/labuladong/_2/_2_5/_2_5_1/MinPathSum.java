package leetcode.suanfa.labuladong._2._2_5._2_5_1;

import org.springframework.aop.scope.ScopedProxyUtils;

public class MinPathSum {

    //最小路径和
    /**
     * 现在给你输入一个二维数组 grid，其中的元素都是非负整数，现在你站在左上角，只能向右或者向下移动，需要到达右下角。
     * 现在请你计算，经过的路径和最小是多少？
     */

    public static int minPathSum(int[][] grid) {
        return dp(grid, 0, 0);
    }
    //从grid[i][j]到grid[m - 1][n - 1]所经过的最小路径和
    public static int dp(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(i == grid.length - 1) {
            return grid[i][j] + dp(grid, i, j + 1);
        }
        if(j == grid[0].length - 1) {
            return grid[i][j] + dp(grid, i + 1, j);
        }
        return Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) + grid[i][j];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
