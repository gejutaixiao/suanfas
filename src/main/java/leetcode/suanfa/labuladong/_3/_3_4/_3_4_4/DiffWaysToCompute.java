package leetcode.suanfa.labuladong._3._3_4._3_4_4;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

    //为运算表达式设计优先级
    /**
     * 简单说，就是给你输入一个算式，你可以给它随意加括号，请你穷举出所有可能的加括号方式，并计算出对应的结果。
     */

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer leftNum : left) {
                    for (Integer rightNum : right) {
                        if (c == '-') {
                            res.add(leftNum - rightNum);
                        } else if (c == '+') {
                            res.add(leftNum + rightNum);
                        } else {
                            res.add(leftNum * rightNum);
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                res.add(Integer.parseInt(input));
            }
        }
        return res;
    }
}
