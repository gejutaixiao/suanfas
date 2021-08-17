package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class _106 {

    //从中序与后序遍历构造二叉树
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 根据一棵树的中序与后序遍历构造二叉树
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
