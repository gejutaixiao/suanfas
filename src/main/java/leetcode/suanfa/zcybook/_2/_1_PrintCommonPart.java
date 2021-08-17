package leetcode.suanfa.zcybook._2;

public class _1_PrintCommonPart {

    //打印两个有序链表的公共部分

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part: ");
        if (head1 == null || head2 == null) {
            return;
        }
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                head2 = head2.next;
            } else if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}


