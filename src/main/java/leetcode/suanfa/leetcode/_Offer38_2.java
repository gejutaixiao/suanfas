package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _Offer38_2 {

    //字符串的排列
    static List<String> list = new ArrayList<>();
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n = chars.length;
        boolean[] vis = new boolean[n];
        LinkedList<Character> track = new LinkedList<>();
        dfs(chars, vis, 0, track);
        String[] res = new String[list.size()];
        int index = 0;
        for (String s1 : list) {
            res[index++] = s1;
        }
        return res;
    }
    public static void dfs(char[] chs, boolean[] vis, int index, LinkedList<Character> track) {
        if (index == chs.length) {
            StringBuffer sb = new StringBuffer();
            for (Character character : track) {
                sb.append(character);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (vis[i] || (i > 0 && chs[i] == chs[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            track.add(chs[i]);
            dfs(chs, vis, index + 1, track);
            vis[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        String[] abcs = permutation("abc");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
}
