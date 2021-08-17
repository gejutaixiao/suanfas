package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _449 {

    //序列化与反序列化二叉搜索树
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
     *
     * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
     * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
     *
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        for (String s : data.split(",")) {
            queue.add(s);
        }
        return deserialize(queue);
    }
    public TreeNode deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String rootVal = list.remove();
        if(rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
