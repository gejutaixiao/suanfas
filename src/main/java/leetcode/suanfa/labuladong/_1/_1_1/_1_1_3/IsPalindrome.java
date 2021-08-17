package leetcode.suanfa.labuladong._1._1_1._1_1_3;

import leetcode.suanfa.labuladong._1.Node;
import org.springframework.beans.propertyeditors.CurrencyEditor;

import java.util.Stack;

public class IsPalindrome {
    //判断一个链表是否为回文链表

    //1.不利用任何额外空间的迭代
    public static boolean isPalindrome1(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        Node right = reverse(slow);
        Node left = head;
        while(right != null) {
            if(right.val != left.val) {
                return false;
            }
        }
        return true;
    }
    public static Node reverse(Node head) {
        Node pre = null, next = head, cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //2.利用O(N)空间的迭代
    public static boolean isPalindrome2(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Node left = head;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(left != null) {
            stack.push(left.val);
            left = left.next;
            index++;
        }
        int i = 0;
        while(i < index / 2) {
            if(stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
