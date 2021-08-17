package leetcode.suanfa.gongshuisanye.DFS;

import java.util.LinkedList;
import java.util.List;

public class _22 {

    //括号的生成

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(n, n, res, "");
        return res;
    }

    private void dfs(int left, int right, List<String> res, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > right || left < 0 || right < 0) {
            return;
        }
        String tmp = s;
        s += ")";
        dfs(left, right - 1, res, s);
        s = tmp;
        s += "(";
        dfs(left - 1, right - 1, res, s);
        s = tmp;
    }

}
