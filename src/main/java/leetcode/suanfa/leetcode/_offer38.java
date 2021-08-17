package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _offer38 {

    //字符串的排列
    /**
     * 输入一个字符串，打印出该字符串的所有排列
     * 可以任意顺序返回字符串的所有排列，但是不能含有重复元素
     */

    static List<String> res = new ArrayList<>();
    public static List<String> all(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        Arrays.sort(arr);
        boolean[] vis = new boolean[n];

        dfs(arr, 0, vis, "");
        return res;
    }
    public static void dfs(int[] arr, int index, boolean[] vis, String s) {
        if (index == arr.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] || (i > 0 && arr[i - 1] == arr[i] && !vis[i - 1])) {
                continue;
            }
            String tmp = s;
            s += (char)(arr[i] + 'a');
            vis[i] = true;
            dfs(arr, index + 1, vis, s);
            vis[i] = false;
            s= tmp;
        }
    }

    public static void main(String[] args) {
        List<String> abc = all("abac");
        for (String s : abc) {
            System.out.println(s);
        }
    }
}
