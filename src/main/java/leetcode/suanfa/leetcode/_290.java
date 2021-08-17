package leetcode.suanfa.leetcode;

import java.util.HashMap;

public class _290 {

    //单词规律
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     */
    //"abc"
    //"dog cat dog"
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) {
            return false;
        }
        HashMap<String, Character> sTp = new HashMap<>();
        HashMap<Character, String> pTs = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            char c = pattern.charAt(i);
            if (pTs.containsKey(c) || sTp.containsKey(s1[i])) {
                if ((pTs.containsKey(c) && !pTs.get(c).equals(s1[i])) || (sTp.containsKey(s1[i]) && !sTp.get(s1[i]).equals(c))) {
                    return false;
                }
            } else {
                pTs.put(c, s1[i]);
                sTp.put(s1[i], c);
            }
        }
        return true;
    }

}
