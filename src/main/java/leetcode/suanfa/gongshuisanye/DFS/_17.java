package leetcode.suanfa.gongshuisanye.DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _17 {

    //电话号码的字母组合
    Map<Character, String[]> map = new HashMap(){{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});}};
    public List<String> letterCombinations(String ds) {
        int n = ds.length();
        List<String> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        dfs(ds, 0, n, res, sb);
        return res;
    }

    private void dfs(String ds, int i, int n, List<String> res, StringBuffer sb) {
        if (i == n) {
            res.add(sb.toString());
            return;
        }
        for (String s : map.get(ds.charAt(i))) {
            sb.append(s);
            dfs(ds, i + 1, n, res, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
