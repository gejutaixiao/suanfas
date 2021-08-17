package leetcode.suanfa.labuladong._3._3_1._3_1_5;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    //括号生成
    /**
     * 请你写一个算法，输入是一个正整数 n，输出是 n 对儿括号的所有合法组合。
     */

    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> generateParenthesis(int n) {
        LinkedList<String> track = new LinkedList<>();
        dfs(n, n, track);
        return res;
    }
    public static void dfs(int left, int right, LinkedList<String> track) {
        //base case
        if(left == 0 && right == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        //排除不合法
        if (left > right || left < 0 || right < 0) {
            return;
        }

        //做选择
        //添加左括号
        track.add("(");
        dfs(left - 1, right, track);
        //撤销选择
        track.removeLast();
        
        //添加右括号
        track.add(")");
        dfs(left, right - 1, track);
        //撤销选择
        track.removeLast();
    }


    public static void main(String[] args) {
        List<List<String>> lists = generateParenthesis(12);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println(lists.size());
    }
}
