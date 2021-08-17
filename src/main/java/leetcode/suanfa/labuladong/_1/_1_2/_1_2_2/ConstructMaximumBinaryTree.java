package leetcode.suanfa.labuladong._1._1_2._1_2_2;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class ConstructMaximumBinaryTree {

    //给定一个不含重复元素的数组nums。
    //一个以此数组直接递归构建的最大二叉树定义如下：
    //1.二叉树的根是数组nums中的最大元素
    //2.左子树是通过数组中最大值左边部分递归构造出的最大二叉树
    //3.右子树是通过数组中最大值右边部分定义出的最大二叉树
    //返回由给定数组nums构建的最大二叉树

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulid(nums, 0, nums.length - 1);
    }

    private TreeNode bulid(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = left; i <= right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = bulid(nums, left, index - 1);
        root.right = bulid(nums, index + 1, right);
        return root;
    }

}
