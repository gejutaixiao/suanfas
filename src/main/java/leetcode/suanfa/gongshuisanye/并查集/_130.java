package leetcode.suanfa.gongshuisanye.并查集;

import javax.lang.model.type.ReferenceType;

public class _130 {

    //被围绕的区域
    //并查集
    int m, n;
    class UF {
        int[] p;
        public UF(char[][] board) {
            m = board.length;
            n = board[0].length;
            p = new int[m * n + 1];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }
        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }
        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
        boolean connected(int a, int b) {
            return p[find(a)] == p[find(b)];
        }
    }
    public void solve(char[][] board) {
        UF uf = new UF(board);
        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(getIndex(i, 0), dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(getIndex(i, n - 1), dummy);
            }
        }
        for (int j = 0; j < n; j++) {
            //判断第一行和最后一行
            if (board[0][j] == 'O') {
                uf.union(getIndex(0, j), dummy);
            }
            if (board[m - 1][j] == 'O') {
                uf.union(getIndex(m - 1, j), dummy);
            }
        }
        int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    int index = getIndex(i, j);
                    for (int k = 0; k < 4; k++) {
                        int x = matrix[k][0] + i;
                        int y = matrix[k][1] + j;
                        if (board[x][y] == 'O') {
                            uf.union(index, getIndex(x, y));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(getIndex(i, j), dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    int getIndex(int x, int y) {
        return x * n + y;
    }
}
