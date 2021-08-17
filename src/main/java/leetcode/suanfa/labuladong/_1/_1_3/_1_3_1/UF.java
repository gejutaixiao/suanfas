package leetcode.suanfa.labuladong._1._1_3._1_3_1;

public class UF {
    /**
     * 构造函数初始化数据结构需要 O(N) 的时间和空间复杂度；
     * 连通两个节点union、判断两个节点的连通性connected、计算连通分量count所需的时间复杂度均为 O(1)。
     */

    //记录连通分量
    public int count;
    //存储一棵树
    public int[] parent;
    //记录每棵树的“重量”
    public int[] size;

    public UF(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //连通两个节点
    public void union(int p, int q) {
        //找到p的根节点
        int rootP = find(p);
        //找到q的根节点
        int rootQ = find(q);

        //将小树连接到大树下面
        if (size[rootP] > size[rootQ]) {
           parent[rootQ] = rootP;
           size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        this.count--;
    }

    //判断两个节点的连通性
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //寻找节点的根节点
    public int find(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //计算连通分量
    public int count() {
        return this.count;
    }
}
