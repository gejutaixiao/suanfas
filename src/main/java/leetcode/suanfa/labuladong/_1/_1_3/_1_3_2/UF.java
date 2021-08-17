package leetcode.suanfa.labuladong._1._1_3._1_3_2;

public class UF {

    //记录每个节点的父节点
    int[] parent;
    //记录每棵树的重量
    int[] size;
    //记录总连通数
    int count;

    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //将两个节点连通
    public void union(int p, int q) {
        int rootQ = find(q);
        int rootP = find(p);

        if(rootP == rootQ) {
            return;
        }
        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    //判断两个节点是否连通
    public boolean connected(int q, int p) {
        int rootQ = find(q);
        int rootP = find(p);
        return rootP == rootQ;
    }

    //寻找节点的父节点
    public int find(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //返回连通节点个数
    public int count() {
        return this.count;
    }
}
