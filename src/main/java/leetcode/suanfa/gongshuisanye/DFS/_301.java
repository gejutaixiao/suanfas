package leetcode.suanfa.gongshuisanye.DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _301 {

    //删除无效的括号
    int len;
    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for (char c : cs) {
            if (c == ')') {
                r++;
            } else if (c =='('){
                l++;
            }
        }
        int max = Math.min(l, r);
        Set<String> set = new HashSet<>();
        dfs(cs, 0, 0, max, set, "");
        List<String> res = new LinkedList<>();
        for (String s1 : set) {
            if (len == s1.length()) res.add(s1);
        }
        return res;
    }

    private void dfs(char[] cs, int index, int sorce, int max, Set<String> set, String s) {
        if (index == cs.length) {
            if (sorce == 0 && s.length() >= len) {
                len = Math.max(len, s.length());
                set.add(s);
            }
            return;
        }
        if (cs[index] == '(') {
            if (sorce + 1 <= max) {
                dfs(cs, index + 1, sorce + 1, max, set, s + "(");
            }
            dfs(cs, index + 1, sorce, max, set, s);
        } else if (cs[index] == ')') {
            if (sorce > 0) {
                dfs(cs, index + 1, sorce - 1, max, set, s + ")");
            }
            dfs(cs, index + 1, sorce, max, set, s);
        } else {
            dfs(cs, index + 1, sorce, max, set, s + String.valueOf(cs[index]));
        }
    }
}
