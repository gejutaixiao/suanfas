package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _297 {

    //二叉树的序列化与反序列化
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
     * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     */

    //二叉树的前序序列化与反序列化
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
        Queue<String> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.add(s);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(Queue<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String rootVal = list.remove();
        if(rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}

//二叉树后序序列化与反序列化
class solution {
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
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val).append(",");
    }
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.add(s);
        }
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }
        String rootVal = list.removeLast();
        if(rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        root.right = deserialize(list);
        root.left = deserialize(list);
        return root;
    }
}
