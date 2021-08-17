package leetcode.suanfa.gongshuisanye.并查集;

public class _1319 {

    //连通网络的操作次数

    class UF {
        int count;
        int[] p;
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
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public int getCount() {
            return count;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }
        UF uf = new UF(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        return uf.getCount() - 1;
    }
}
