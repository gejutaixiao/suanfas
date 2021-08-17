package leetcode.suanfa.labuladong._3._3_3._3_3_4;

public class MyPow {

    //如何高效求幂

    public static int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b % 2 == 1) {
            //b为奇数
            return (a * myPow(a, b - 1));
        } else {
            int res = myPow(a, b / 2);
            return res * res;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 2));
    }
}
