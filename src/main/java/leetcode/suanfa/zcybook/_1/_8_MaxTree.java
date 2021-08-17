package leetcode.suanfa.zcybook._1;

public class _8_MaxTree {

    //构造数组的maxTree
    /**
     * 一个数组的MaxTree定义如下
     * 1.数组必须没有重复元素
     * 2.MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点
     * 3.包含MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头
     */

    public Node maxTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }
    public Node maxTree(int[] nums, int left, int right) {
        //base case
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new Node(nums[left]);
        }
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        Node root = new Node(max);
        root.left = maxTree(nums, left, maxIndex - 1);
        root.right = maxTree(nums, maxIndex + 1, right);
        return root;
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node (int val) {
        value = val;
    }
}
