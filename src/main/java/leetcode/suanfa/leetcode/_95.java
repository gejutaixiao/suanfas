package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _95 {

    //不同的二叉搜索树Ⅱ
    //https://leetcode-cn.com/tag/tree/problemset/

    public List<TreeNode> numTrees(int n) {
        return build(1, n);
    }
    public List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> lefts = build(start, i - 1);
            List<TreeNode> rights = build(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
