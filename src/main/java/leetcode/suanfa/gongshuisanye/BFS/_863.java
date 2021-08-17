package leetcode.suanfa.gongshuisanye.BFS;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.*;

public class _863 {

    //863. 二叉树中所有距离为 K 的结点

    int N = 510;
    int M = N * 4;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int index;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[N];
        Arrays.fill(he, -1);
        dfs(root);
        queue.add(target.val);
        vis[target.val] = true;
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (k == 0) {
                    res.add(poll);
                    continue;
                }
                for (int j = he[poll]; j != -1; j = ne[j]) {
                    int next = e[j];
                    if (!vis[next]) {
                        queue.add(next);
                        vis[next] = true;
                    }
                }
            }
            k--;
        }
        return res;
    }
    public void add(int a, int b) {
        e[index] = b;
        ne[index] = he[a];
        he[a] = index++;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}
