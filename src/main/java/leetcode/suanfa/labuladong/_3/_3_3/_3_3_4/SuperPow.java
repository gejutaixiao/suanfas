package leetcode.suanfa.labuladong._3._3_3._3_3_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SuperPow {

    //超级次方
    /**
     * 要求你的算法返回幂运算 a^b 的计算结果与 1337 取模（mod，也就是余数）后的结果。就是你先得计算幂 a^b，但是这个 b 会非常大，所以 b 是用数组的形式表示的。
     */

    public static int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.add(i);
        }
        return superPows(a, list);
    }
    public static int superPows(int a, LinkedList<Integer> b) {
        if (b.isEmpty()) {
            return 1;
        }
        int base = 1337;
        Integer pollLast = b.pollLast();
        int part1 = pow(a, pollLast);
        int part2 = pow(superPows(a, b), 10);
        return (part1 * part2) % base;
    }

    //计算a的b次方，然后与base求模的结果
    public static int pow(int a, int b) {
        int base = 1377;
        //对因子求模
        a %= base;
        int res = 1;
        for (int i = 0; i < b; i++) {
            //这有乘法，是潜在的溢出点
            res *= a;
            //对结果求模
            res %= base;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] b= {1, 5, 6, 4};
        System.out.println(superPow(5, b));
    }
}
