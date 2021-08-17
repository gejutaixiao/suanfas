package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _508 {

    //出现次数最多的子树元素和
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     *
     * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     *
     */


    /**
     * 本题利用中序遍历和后序遍历用时相差较大。
     */
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxCount = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        nodeSum(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public int nodeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = nodeSum(root.left);
        int right = nodeSum(root.right);
        int sum = left + right + root.val;
        if(!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            int count = map.get(sum);
            map.put(sum, count + 1);
            maxCount = Math.max(maxCount, count + 1);
        }
        return sum;
    }


}
