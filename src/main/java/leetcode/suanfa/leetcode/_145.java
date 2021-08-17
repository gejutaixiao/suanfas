package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class _145 {

    //二叉树的后序遍历
    //https://leetcode-cn.com/tag/tree/problemset/

    //给定一棵二叉树，返回它的后序遍历

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

