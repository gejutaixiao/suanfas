package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNodes;

public class _116 {

    //填充每个节点的下一个右侧节点指针
    //https://leetcode-cn.com/tag/tree/problemset/
    //给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点
    //请填充它的每个next指针，让这个指针指向其下一个右侧节点。
    //如果找不到下一个右侧节点，则将next指针设置为null
    //初始状态下，所有next指针都被设置为null

    public TreeNodes connect(TreeNodes root) {
        if(root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    private void connect(TreeNodes node1, TreeNodes node2) {
        if(node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        //连接node1的左右子树
        connect(node1.left, node1.right);
        //连接node2的左右子树
        connect(node2.left, node2.right);
        //将node1.right与node2.left连接起来
        connect(node1.right, node2.left);
    }
}
