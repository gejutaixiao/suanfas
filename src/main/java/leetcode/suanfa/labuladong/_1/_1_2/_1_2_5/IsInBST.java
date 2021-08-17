package leetcode.suanfa.labuladong._1._1_2._1_2_5;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import sun.font.TrueTypeGlyphMapper;

public class IsInBST {
    /**
     * 在BST中搜索一个数
     */
    public boolean isInBST(TreeNode root, int target) {
        if(root == null) return false;
        if(root.val == target) {
            return true;
        } else if(root.val < target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }
}
