package leetcode.suanfa.labuladong._1._1_2._1_2_3;

import leetcode.suanfa.leetcode.listNode.ListNode;
import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {

    //寻找重复的子树
    //给定一课二叉树，返回所有重复的子树。对于同一类的重复子树，你只需返回其中任意一棵的根结点即可
    //两棵树重复是指它们具有相同的结构以及相同的结点值

    public List<TreeNode> res = new ArrayList<>();
    public HashMap<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //二叉树的后序序列化
    public String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String str = left + "," + right + "," + root.val;
        int num = map.getOrDefault(str, 0);
        if(num == 1) {
            res.add(root);
        }
        map.put(str, num + 1);
        return str;
    }
}
