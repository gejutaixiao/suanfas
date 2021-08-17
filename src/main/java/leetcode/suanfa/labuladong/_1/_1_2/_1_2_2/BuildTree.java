package leetcode.suanfa.labuladong._1._1_2._1_2_2;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class BuildTree {

    //从前序与中序遍历序列构造二叉树
    //根据一棵树的前序遍历与中序遍历构造二叉树

    public TreeNode bulidTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend) {
            return null;
        }
        int rootVal = preorder[prestart];
        int index = 0;
        for(int i = instart; i <= inend; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - instart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, prestart + 1, prestart + leftSize, inorder, instart, index - 1);
        root.right = build(preorder, prestart + leftSize + 1, preend, inorder, index + 1, inend);
        return root;
    }
}
