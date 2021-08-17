package leetcode.suanfa.leetcode;


import leetcode.suanfa.leetcode.treenode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class _965 {

    //单值二叉树
    /**
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     */
    int pre = -1;
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            if (pre != root.val) {
                flag = false;
                return;
            }
        }
        dfs(root.right);
    }

}
