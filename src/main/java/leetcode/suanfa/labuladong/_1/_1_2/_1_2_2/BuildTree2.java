package leetcode.suanfa.labuladong._1._1_2._1_2_2;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class BuildTree2 {

    //从中序与后续遍历构造二叉树
    //根据一棵树的中序与后序遍历构造二叉树

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
