package leetcode.suanfa.leetcode;


public class _990 {

    //等式方程的可满足性
    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
     * 在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     *
     */

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if(equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '!') {
                if(uf.connected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
class UF {
    int parent[];
    int size[];
    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
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
    }

    public int find(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}
