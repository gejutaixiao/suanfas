package leetcode.suanfa.labuladong._4._4_5;

import java.util.Stack;

public class Calculate1 {

    //简单的计算器

    /**
     * 实现传入一段字符串，返回其中的计算结果，只含有加减符号
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果为数字
            if (isDigit(c)) {
                //连续数字
                num = num * 10 + (c - '0');
            }
            //c不是数字，或者当前到了字符串最后
            if (!isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '-' :
                        stack.push(-1 * num);
                        break;
                    case '+' :
                        stack.push(num);
                        break;
                }
                //更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static boolean isDigit(char c) {
        if (c >= '1' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+2-6"));
    }
}
