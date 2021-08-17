package leetcode.suanfa.leetcode;

public class _79 {

    int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean res = false;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = dfs(board, i, j, word, 0, vis);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] vis) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length()) {
            return true;
        }

        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + matrix[k][0];
            int y = j + matrix[k][1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y]) {
                continue;
            }

            if (dfs(board, x, y, word, index + 1, vis)) {
                return true;
            }

        }
        vis[i][j] = false;
        return false;
    }
}
