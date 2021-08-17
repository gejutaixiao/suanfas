package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1239 {

    //串联字符串的最大长度
    /**
     * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
     * <p>
     * 请返回所有可行解 s 中最长长度。
     * <p>
     * 示例 1：
     * 输入：arr = ["un","iq","ue"]
     * 输出：4
     * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
     * <p>
     * 示例 2：
     * 输入：arr = ["cha","r","act","ers"]
     * 输出：6
     * 解释：可能的解答有 "chaers" 和 "acters"。
     */
    static int max = 0;

    public static int maxLength(List<String> arr) {
        if (arr.size() == 1) {
            return arr.get(0).length();
        }

        boolean[] vis = new boolean[26];
        dfs(0, arr, vis, "");
        return max;
    }

    private static void dfs(int i, List<String> arr, boolean[] vis, String str) {
        if (i == arr.size()) {
            max = Math.max(max, str.length());
            return;
        }
        for (int k = i; k < arr.size(); k++) {
            String s = arr.get(k);
            boolean flag = true;
            int index = s.length();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (vis[c - 'a']) {
                    flag = false;
                    index = j;
                    break;
                }
                vis[c - 'a'] = true;
            }
            String tmp = str;
            if (flag) {
                str += s;
            }
            dfs(k + 1, arr, vis, str);
            str = tmp;
            for (int j = 0; j < index; j++) {
                char c = s.charAt(j);
                vis[c - 'a'] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
//        arr.add("ers");
        System.out.println(maxLength(arr));
    }
}
