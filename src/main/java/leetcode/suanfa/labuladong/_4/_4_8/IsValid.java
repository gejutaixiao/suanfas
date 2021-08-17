package leetcode.suanfa.labuladong._4._4_8;

import java.util.Stack;

public class IsValid {

    //有效的括号

    /**
     * 题目很简单，输入一个字符串，其中包含 [](){} 六种括号，请你判断这个字符串组成的括号是否合法。
     * @param string
     * @return
     */
    public static boolean isValid(String string) {
        int n = string.length();
        if (n % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = string.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (c) {
                    case '}' :
                        if (stack.peek() != '{') return false;
                        break;
                    case ')' :
                        if (stack.peek() != '(') return false;
                        break;
                    case ']' :
                        if (stack.peek() != '[') return false;
                        break;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}{}{}{}()()()()(){{[]()}}"));
    }
}
