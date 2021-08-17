package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _872 {

    //叶子相似的树
    /**
     * 给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     *
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     *
     * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     *
     */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        help(root1, l1);
        help(root2, l2);
        if(l1.size() != l2.size()) {
            return false;
        }
        for(int i = 0; i < l1.size(); i++) {
            if(l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void help(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            res.add(root.val);
        }
        if(root.left != null) {
            help(root.left, res);
        }
        if(root.right != null) {
            help(root.right, res);
        }
    }
}
