package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.Node;

public class _117 {

    //填充每个节点的下一个右侧节点指针Ⅱ
    //https://leetcode-cn.com/tag/tree/problemset/
    /**
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     */

    Node last = null;
    Node nextStart = null;
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Node start = root;
        while(start != null) {
            last = null;
            nextStart = null;
            for(Node tmp = start; tmp != null; tmp = tmp.next) {
                if(tmp.left != null) {
                    handle(tmp.left);
                }
                if(tmp.right != null) {
                    handle(tmp.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    public void handle(Node root) {
        if(last != null) {
            last.next = root;
        }
        if(nextStart == null) {
            nextStart = root;
        }
        last = root;
    }
}
