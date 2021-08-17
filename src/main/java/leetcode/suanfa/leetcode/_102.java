package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {

    //二叉树的层序遍历
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();
                if(tmp != null) {
                    list.add(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
            if(list.size() > 0)
                res.add(list);
        }
        return res;
    }
}
