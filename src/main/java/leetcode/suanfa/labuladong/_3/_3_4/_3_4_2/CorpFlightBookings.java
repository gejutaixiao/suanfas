package leetcode.suanfa.labuladong._3._3_4._3_4_2;

public class CorpFlightBookings {

    //航班预定统计
    /**
     * 给你输入一个长度为n的数组nums，其中所有元素都是 0。
     * 再给你输入一个bookings，里面是若干三元组(i,j,k)，每个三元组的含义就是要求你给nums数组的闭区间[i-1,j-1]中所有元素都加上k。
     * 请你返回最后的nums数组是多少？
     *
     * PS：因为题目说的n是从 1 开始计数的，而数组索引从 0 开始，所以对于输入的三元组(i,j,k)，数组区间应该对应[i-1,j-1]。
     */

    int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference difference = new Difference(res);
        for (int[] booking : bookings) {
            difference.increment(booking[0], booking[1], booking[2]);
        }
        return difference.result();
    }
}
