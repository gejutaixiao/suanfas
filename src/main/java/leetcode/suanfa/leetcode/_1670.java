package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.listNode.ListNode;

public class _1670 {

    //设计前中后队列
    /**
     * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
     *
     * 请你完成 FrontMiddleBack 类：
     *
     * FrontMiddleBack() 初始化队列。
     * void pushFront(int val) 将 val 添加到队列的 最前面 。
     * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
     * void pushBack(int val) 将 val 添加到队里的 最后面 。
     * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
     * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
     * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
     * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
     *
     * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
     * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
     *
     * 输入：
     * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
     * [[], [1], [2], [3], [4], [], [], [], [], []]
     * 输出：
     * [null, null, null, null, null, 1, 3, 4, 2, -1]
     *
     * 解释：
     * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
     * q.pushFront(1);   // [1]
     * q.pushBack(2);    // [1, 2]
     * q.pushMiddle(3);  // [1, 3, 2]
     * q.pushMiddle(4);  // [1, 4, 3, 2]
     * q.popFront();     // 返回 1 -> [4, 3, 2]
     * q.popMiddle();    // 返回 3 -> [4, 2]
     * q.popMiddle();    // 返回 4 -> [2]
     * q.popBack();      // 返回 2 -> []
     * q.popFront();     // 返回 -1 -> [] （队列为空）
     *
     */
    ListNode head;
    int size = 0;
    public _1670() {
        head = new ListNode(-1);
    }

    public void pushFront(int val) {
        ListNode next = head.next;
        ListNode cur = new ListNode(val);
        head.next = cur;
        cur.next = next;
        size++;
    }

    public void pushMiddle(int val) {
        if(size == 0) {
            pushFront(val);
            return;
        }
        ListNode slow = head.next, fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = new ListNode(val);
        if(fast == null) {
            ListNode cur = head;
            while(cur.next != slow) {
                cur = cur.next;
            }

            cur.next = tmp;
            tmp.next = slow;
        } else {
            ListNode next = slow.next;
            slow.next = tmp;
            tmp.next = next;
        }
        size++;
    }

    public void pushBack(int val) {
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    public int popFront() {
        if(head.next == null) {
            return -1;
        }
        int val = head.next.val;
        head.next = head.next.next;
        size--;
        return val;
    }

    public int popMiddle() {
        if(head.next == null) {
            return -1;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        size--;
        if(slow.next == null) {
            int val = slow.val;
            head.next = null;
            return val;
        }
        int val = slow.val;
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return val;
    }

    public int popBack() {
        if(head.next == null) {
            return -1;
        }
        ListNode cur = head;
        while(cur.next != null && cur.next.next != null) {
            cur = cur.next;
        }
        int val = cur.next.val;
        cur.next = null;
        size--;
        return val;
    }

    public static void main(String[] args) {
        _1670 q = new _1670();
//        q.pushFront(1);   // [1]
//        q.pushBack(2);    // [1, 2]
//        q.pushMiddle(3);  // [1, 3, 2]
//        q.pushMiddle(4);  // [1, 4, 3, 2]
//        System.out.println(q.popFront());     // 返回 1 -> [4, 3, 2]
//        System.out.println(q.popMiddle());
//        System.out.println(q.popMiddle());
//        System.out.println(q.popBack());
//        System.out.println(q.popFront());
        q.pushMiddle(1);
        q.pushMiddle(2);
        q.pushMiddle(3);
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
//     q.popMiddle();    // 返回 3 -> [4, 2]
//     q.popMiddle();    // 返回 4 -> [2]
//     q.popBack();      // 返回 2 -> []
//     q.popFront();     // 返回 -1 -> [] （队列为空）
    }
}
