package leetcode.suanfa.labuladong._1._1_3._1_3_2;

public class Slove_UF {
    /**
     * 被围绕的区域：给你一个 M×N 的二维矩阵，其中包含字符 X 和 O，让你找到矩阵中四面被 X 围住的 O，并且把它们替换成 X。
     */

    public void slove(char[][] board) {
        //m行
        int m = board.length;
        //n列
        int n = board[0].length;
        UF uf = new UF(m * n + 1);
        int dummy = m * n;

        //将第一行和最后一行与dummy连通
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if(board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, dummy);
            }
        }

        //将第一列和最后一列与dummy连接
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if(board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }

        int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(board[i][j] == 'O') {
                    for(int k = 0; k < 4; k++) {
                        int x = d[k][0];
                        int y = d[k][1];
                        if(board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        //所有不和dummy连通的O都要被替换
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!uf.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
