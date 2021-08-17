package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _282 {

    //给表达式添加运算符

    /**
     * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加 二元 运算符（不是一元）+、- 或 * ，
     * 返回所有能够得到目标值的表达式。
     */

    public static List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return null;
        }
        ArrayList<String> res = new ArrayList<>();
        String track = "";
        dfs(num, 0, target, track, res);
        return res;
    }

    private static void dfs(String num, int i, int target, String track, ArrayList<String> res) {
        if (i == num.length()) {
            if (getNum(track) == target) {
                res.add(track);
            }
            return;
        }
        for (int k = i; k < num.length(); k++) {
            String substring = num.substring(i, k + 1);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                break;
            }
            char[] chs = {'+', '-', '*'};
            String tmp = track;
            if (i == 0) {
                track += substring;
                dfs(num, k + 1, target, track, res);
                track = tmp;
            } else {
                for (int j = 0; j < 3; j++) {
                    track = track + chs[j] + substring;
                    dfs(num, k + 1, target, track, res);
                    track = tmp;
                }
            }

        }
    }

    private static long getNum(String track) {
        long num = 0;
        char sign = '+';
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < track.length(); i++) {
            char c = track.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!isDigit(c) || i == track.length() - 1) {
                switch (sign) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        Long pop = stack.pop();
                        stack.push(pop * num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }

        long res = 0;
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
        List<String> strings = addOperators("00", 0);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
