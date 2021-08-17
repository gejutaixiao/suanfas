package leetcode.suanfa.labuladong._1._1_2._1_2_1;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import leetcode.suanfa.leetcode.treenode.TreeNodes;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {

    //填充每个节点的下一个右侧节点指针
    //给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
    //填充他的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针指向null

    //1.递归方法
    public TreeNodes connect1(TreeNodes root) {
        if(root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }
    public void connectTwoNode(TreeNodes node1, TreeNodes node2) {
        if(node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        //连接node1的左右子树
        connectTwoNode(node1.left, node1.right);
        //连接node2的左右子树
        connectTwoNode(node2.left, node2.right);
        //连接不是同一父节点下的两个子树节点
        connectTwoNode(node1.right, node2.left);
    }

    //2.利用二叉树按层遍历求解
    public TreeNodes connect2(TreeNodes root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNodes> queue = new LinkedList<>();
        queue.add(root);
        TreeNodes temp = null;
        int size = 0;
        while(!queue.isEmpty()) {
            size = queue.size();
            for(int i = 0; i < size; i++) {
                temp = queue.remove();
                if (temp != null) {
                    if(i != size - 1) {
                        temp.next = queue.peek();
                    }
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }
}
