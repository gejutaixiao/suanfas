package leetcode.suanfa.leetcode;

public class Offer13 {
    static int res = 0;
    static int[][] matrix = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        dfs(m, n, 0, 0, k, vis);
        return res;
    }
    public static void dfs(int m, int n, int i, int j, int k, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] == true) {
            return;
        }
        if (isVlaid(i, j, k)) {
            res++;
        }
        vis[i][j] = true;
        for (int t = 0; t < 4; t++) {
            int x = i + matrix[t][0];
            int y = j + matrix[t][1];
            dfs(m, n, x, y, k, vis);
        }
    }
    public static boolean isVlaid(int i, int j, int k) {
        int res = getNum(i) + getNum(j);
        return res <= k;
    }
    public static int getNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }
}
