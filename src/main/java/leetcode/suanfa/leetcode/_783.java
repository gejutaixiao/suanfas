package leetcode.suanfa.leetcode;


import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _783 {

    //二叉搜索树节点最小距离
    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

    //输入：root = [4,2,6,1,3]
    //输出：1
    //因为是二叉搜索树，所以利用二叉树的中序遍历便可以求本题

    //https://leetcode-cn.com/tag/tree/problemset/

    int pre;
    int min_value;

    public int minDiffInBST(TreeNode root) {
        pre = -1;
        min_value = Integer.MAX_VALUE;
        dfs(root);
        return min_value;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(pre == -1) {
            pre = root.val;
        } else {
            min_value = Math.min(min_value, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
