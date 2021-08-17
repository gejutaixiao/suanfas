package leetcode.suanfa.labuladong._3._3_3._3_3_7;

import leetcode.suanfa.leetcode.listNode.ListNode;

import java.util.Random;

public class GetRandom {

    /**
     * 给你一个未知长度的链表，请你设计一个算法，只能遍历一次，随机地返回链表中的一个节点。
     * 这里说的随机是均匀随机（uniform random），也就是说，如果有 n 个元素，每个元素被选中的概率都是 1/n，不可以有统计意义上的偏差。
     * @param head
     * @return
     */

    //返会链表中的一个随机节点
    public static int getRandom(ListNode head) {
        int res = 0, i = 0;
        ListNode cur = head;
        Random random = new Random();
        while (cur != null) {
            //生成一个[0, i) 之间的整数
            //取到这个整数的概率为1/i
            if (random.nextInt(++i) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }

    //同理，如果要随机选择 k 个数，只要在第 i 个元素处以 k/i 的概率选择该元素，以 1 - k/i 的概率保持原有选择即可。
    //返回链表中k个随即节点的值
    public static int[] getRandoms(ListNode head, int k) {
        int[] res = new int[k];
        int i = 0;
        Random random = new Random();
        ListNode cur = head;
        //前k个节点默认先选上
        for (; i < k && cur != null; i++, cur = cur.next) {
            res[i] = cur.val;
        }
        //while循环
        while (cur != null) {
            //生成一个[0, i) 之间的整数
            int nextInt = random.nextInt(++i);
            //这个数小于k的几率是k/i
            if (nextInt < k) {
                res[nextInt] = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
