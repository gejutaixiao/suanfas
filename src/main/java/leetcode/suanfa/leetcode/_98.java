package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _98 {

    //验证二叉搜索树
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    List<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        int pre = -1;
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                pre = list.get(i);
                continue;
            }
            if(pre >= list.get(i)) {
                return false;
            }
            pre = list.get(i);
        }
        return true;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        return build(root, null, null);
    }

    private boolean build(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        if(min != null && min.val >= root.val) {
            return false;
        }
        if(max != null && max.val <= root.val) {
            return false;
        }
        return build(root.left, min, root) && build(root.right, root, max);
    }
}
