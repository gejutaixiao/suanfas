package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103 {

    //二叉树的锯齿形层序遍历
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                TreeNode tmp = queue.remove();
                if(flag) {
                    list.add(tmp.val);
                } else {
                    list.add(0, tmp.val);
                }
                if(tmp.left != null) {
                    queue.add(tmp.left);
                }
                if(tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
