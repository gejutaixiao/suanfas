package leetcode.suanfa.leetcode;

import leetcode.suanfa.labuladong._1._1_2._1_2_2.BuildTree;
import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _105 {

    //从前序与中序遍历构造二叉树
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 根据一棵树的前序与中序遍历数组构造二叉树
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
