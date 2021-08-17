package 面试;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class huawei3 {

    public static List<String> getTree(String[] s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("null")) {
                String str = dfs(s, i);
                if (set.contains(str)) {
                    res.add(str);
                }
                set.add(str);
            }

        }
        return res;
    }
    public static String dfs(String[] s, int index) {
        if (index >= s.length) {
            return "";
        }
        if (s[index].equals("null")) {
            return "null";
        }
        String left = dfs(s, index * 2 + 1);
        String right = dfs(s, index * 2 + 2);
        if (left.equals("null") && right.equals("null") || left.equals("") && right.equals("")) {
            return s[index];
        }
        return s[index] + "," + left + "," + right;
    }

    public static void main(String[] args) {
        String[] s = {"1", "2", "3", "4", "null", "2", "4", "null", "null","null", "null", "4", "null", "null", "null"};
        for (String s1 : getTree(s)) {
            System.out.println(s1);
        }
    }
}
