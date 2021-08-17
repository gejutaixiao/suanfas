package leetcode.suanfa.labuladong._4._4_5;

import java.util.Stack;

public class Calculate2 {

    //计算器Ⅱ

    /**
     * 实现加减乘除
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int n = s.length();
        int pre = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //如果是数字
            if (isDigit(c)) {
                //加上之前的连续数字
                num = num * 10 + (c - '0');
            }
            //如果不是数字或者到了字符串的最后一位
            if (!isDigit(c) && c != ' '|| i == n - 1) {
                switch (sign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-1 * num);
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
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(calculate2("1 - 2 + 3 * 4 + 3 / 3"));
    }
}
