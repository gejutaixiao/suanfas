package leetcode.suanfa.leetcode;

import org.slf4j.event.SubstituteLoggingEvent;

import java.util.LinkedList;
import java.util.Queue;

public class _130 {

    //被围绕的区域
    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *
     */

    //深度优先遍历
    public void slove(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //遍历第一行与最后一行
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                slove1(board, 0, i, m, n);
            }
            if(board[m - 1][i] == 'O') {
                slove1(board, m - 1, i, m, n);
            }
        }
        //遍历第一列与最后一列
        for(int i = 1; i < m - 1; i++) {
            if(board[i][0] == 'O') {
                slove1(board, i, 0, m, n);
            }
            if(board[i][n - 1] == 'O') {
                slove1(board, i, n - 1, m, n);
            }
        }
        //将被包围的'O'替换为'X'
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    public void slove1(char[][] board, int x, int y, int m, int n) {
        if(x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        board[x][y] = 'A';
        slove1(board, x + 1, y, m, n);
        slove1(board, x - 1, y, m, n);
        slove1(board, x, y + 1, m, n);
        slove1(board, x, y - 1, m, n);
    }

    //广度优先遍历
    public void solve(char[][] board) {
        int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < n; i ++) {
            if(board[0][i] == 'O') {
                queueX.add(0);
                queueY.add(i);
            }
            if(board[m - 1][i] == 'O') {
                queueX.add(m - 1);
                queueY.add(i);
            }
        }
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                queueX.add(i);
                queueY.add(0);
            }
            if(board[i][n - 1] == 'O') {
                queueX.add(i);
                queueY.add(n - 1);
            }
        }
        while(!queueX.isEmpty() && !queueY.isEmpty()) {
            int x = queueX.remove();
            int y = queueY.remove();
            board[x][y] = 'A';
            for(int k = 0; k < 4; k++) {
                int mx = x + d[k][0];
                int my = y + d[k][1];
                if(mx < 0 || mx >= m || my < 0 || my >= n || board[mx][my] != 'O') {
                    continue;
                }
                queueX.add(mx);
                queueY.add(my);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
