package leetcode.suanfa.labuladong._4._4_5;

import java.util.Stack;

public class Calculate3 {

    //实现计算器Ⅲ

    /**
     * 实现一个计算器，里面有加减乘除和括号
     * @param s
     * @return
     */
    public static int[] calculate3(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int pre;
        char sign = '+';
        int n = s.length();
        int len = 0;
        int[] ints = new int[2];
        for (int i = 0; i < n; i++) {
            len++;
            char c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            //判断是否是括号
            if (c == '(') {
                ints = calculate3(s.substring(i + 1));
                num = ints[0];
                i += ints[1];
            }
            if (!isDigit(c) && c != ' ' || i == n - 1) {
                switch (sign) {
                    case '-' :
                        stack.push(-1 * num);
                        break;
                    case '+' :
                        stack.push(num);
                        break;
                    case '*' :
                        pre = stack.pop();
                        num = num * pre;
                        stack.push(num);
                        break;
                    case '/' :
                        pre = stack.pop();
                        num = pre / num;
                        stack.push(num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return new int[]{res, len + ints[1]};
    }

    //判断一个字符是否是数字
    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculate3("3*(2-6/(3-7))")[0]);
        System.out.println(calculate3("3*(4-5/2)-6")[0]);
        System.out.println(calculate3("(1+(4+(5-3)+2)-3)+(6+8)")[0]);
    }
}
