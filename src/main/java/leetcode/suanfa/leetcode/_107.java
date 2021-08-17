package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107 {

    //二叉树的层序遍历Ⅱ

    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。
     *（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();
                list.add(tmp.val);
                if(tmp.left != null) {
                    queue.add(tmp.left);
                }
                if(tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
