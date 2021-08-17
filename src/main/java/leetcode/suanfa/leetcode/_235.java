package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.AccessibleObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _235 {

    //二叉搜索树的最近公共祖先
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     *  “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        List<TreeNode> left = getNode(root, p);
        List<TreeNode> right = getNode(root, q);
        TreeNode ancestor = null;
        for(int i = 0; i < left.size() && i < right.size(); i++) {
            if(left.get(i).val == right.get(i).val) {
                ancestor = left.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }
    public List<TreeNode> getNode(TreeNode root, TreeNode p) {
        List<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(root.val != p.val) {
            if(root.val > p.val) {
                stack.add(root.left);
                root = root.left;
            } else {
                stack.add(root.right);
                root = root.right;
            }
        }
        stack.add(root);
        return stack;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true) {
            if(p.val < root.val && q.val < root.val) {
                ancestor = ancestor.left;
            } else if(p.val > root.val && q.val > root.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

}
