package leetcode.suanfa.leetcode;

public class _547 {

    //省份数量

    class UF {
        int[] p;
        int count;
        public UF(int n) {
            count = n;
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }
        void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if (roota != rootb) {
                p[roota] = rootb;
                count--;
            }
        }
        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
        int getCount() {
            return count;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
