package leetcode.suanfa.labuladong._1._1_2._1_2_6;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    //不同的二叉搜索树Ⅱ
    //生成所有的二叉搜索树

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int mid = start; mid <= end; mid++) {
            List<TreeNode> lefts = build(start, mid - 1);
            List<TreeNode> rights = build(mid + 1, end);
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
