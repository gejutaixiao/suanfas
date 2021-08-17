package leetcode.suanfa.labuladong._2._2_5._2_5_11;

import leetcode.suanfa.leetcode.treenode.TreeNode;

public class Rob3 {

    //打家劫舍Ⅲ
    /**
     * 第三题又想法设法地变花样了，此强盗发现现在面对的房子不是一排，不是一圈，而是一棵二叉树！房子在二叉树的节点上，相连的两个房子不能同时被抢劫：
     */

    public static int rob1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //抢劫本节点
        int do_it = root.val + (root.left != null ? rob1(root.left.left) + rob1(root.left.right) : 0) + (root.right != null ? rob1(root.right.left) + rob1(root.right.right) : 0);
        //不抢劫本节点
        int ndo_it = rob1(root.right) + rob1(root.left);
        return Math.max(do_it, ndo_it);
    }

    public static int rob2(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }

    //定义一个返回值，并相信这个返回值。
    //arr[0]表示不抢劫本节点
    //arr[1]表示抢劫本节点
    public static int[] dp(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //抢，不能去下家
        int do_it = root.val + left[0] + right[0];
        //不抢，下家可抢可不抢
        int not_do = Math.max(Math.max(left[0], left[1]), Math.max(right[0], right[1]));
        return new int[]{not_do, do_it};
    }
}
