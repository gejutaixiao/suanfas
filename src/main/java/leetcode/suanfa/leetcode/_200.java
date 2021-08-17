package leetcode.suanfa.leetcode;

public class _200 {

    //岛屿数量
    //并查集
    int m, n;
    class UF {
        int[] p;
        int[] size;
        int count;
        public UF(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            p = new int[m * n];
            size = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int index = getIndex(i, j);
                        p[index] = index;
                        count++;
                    }
                }
            }
        }
        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                p[rootA] = rootB;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        UF uf = new UF(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int index = getIndex(i, j);
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(index, getIndex(i + 1, j));
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(index, getIndex(i, j + 1));
                    }
                }
            }
        }
        return uf.getCount();
    }
    int getIndex(int i, int j) {
        return i * m + j;
    }
}
