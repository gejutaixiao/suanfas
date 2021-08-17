package leetcode.suanfa.labuladong._2._2_5._2_5_2;

public class CalculateMinimumHP {

    //地下城游戏
    /**
     * 输入一个存储着整数的二维数组 grid，如果 grid[i][j] > 0，说明这个格子装着血瓶，经过它可以增加对应的生命值；
     * 如果 grid[i][j] == 0，则这是一个空格子，经过它不会发生任何事情；如果 grid[i][j] < 0，说明这个格子有怪物，经过它会损失对应的生命值。
     * 现在你是一名骑士，将会出现在最上角，公主被困在最右下角，你只能向右和向下移动，请问你初始至少需要多少生命值才能成功救出公主？
     * 换句话说，就是问你至少需要多少初始生命值，能够让骑士从最左上角移动到最右下角，且任何时候生命值都要大于 0。
     */

    public static int calculateMinimumHP(int[][] grid) {
        return dp(grid, 0, 0);
    }
    //dp(grid,0,0)的含义表明从grid[i][j]到grid[m-1][n-1]所需的最小生命值
    public static int dp(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if(i == grid.length - 1) {
            int res = dp(grid, i, j + 1) - grid[i][j];
            return res <= 0 ? 1 : res;
        }
        if(j == grid[0].length - 1) {
            int res = dp(grid, i + 1, j) - grid[i][j];
            return res <= 0 ? 1 : res;
        }
        int res = Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) - grid[i][j];
        return res <= 0 ? 1 : res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, -10, 20}, {0, 0, 100}, {-1, -1, 0}};
        System.out.println(calculateMinimumHP(grid));
    }
}
