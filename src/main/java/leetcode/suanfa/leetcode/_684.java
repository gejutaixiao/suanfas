package leetcode.suanfa.leetcode;

public class _684 {

    //冗余连接

    class UF {
        int count;
        int[] p;
        public UF (int n) {
            p = new int[n];
            count = n;
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
        int getCount() {
            return count;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int index = n - 1;
        int[] res = null;
        for (int i = 0; i < n; i++) {
            UF uf = new UF(n);
            for (int j = n - 1; j >= 0; j--) {
                if (j == index) continue;
                uf.union(edges[j][0], edges[j][1]);
            }
            if (uf.getCount() == 1) {
                res = edges[index];
                return edges[index];
            }
            index--;
        }
        return res;
    }

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int node1 = edge[0] - 1, node2 = edge[1] - 1;
            if (uf.find(node1) != uf.find(node2)) {
                uf.union(node1, node2);
            } else {
                return edge;
            }
        }
        return edges[0];
    }
}
