package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.Node;

import java.util.HashMap;

public class _Offer35 {

    //复杂链表的复制
    //请实现 copyRandomList 函数，复制一个复杂链表。
    //在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

    //1.利用HashMap表
    public Node copyRandomList1(Node head) {
        Node pre = new Node(-1);
        Node cur = pre;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            cur.next = new Node(temp.val);
            map.put(temp, cur.next);
            cur = cur.next;
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return pre.next;
    }

    //2.利用HashMap表
    public Node copyRandomList2(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    //3.拼接+拆分
    public Node copyRandomList3(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        while(cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
