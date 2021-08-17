package leetcode.suanfa.labuladong._1._1_4._1_4_4;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashMap;

public class MinimumWindowSubstring {

    //最小覆盖子串
    /**
     * 给定一个字符串S，一个字符串T，请在S中找出：包含T的最小字符子串
     */
    public String mininumWindowSubstring(String S, String T) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            need.put(S.charAt(i), need.getOrDefault(S.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while(right < S.length()) {
            //首先将字符c加入滑动窗口
            char c = S.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            //判断左窗口是否需要收缩
            while(valid == need.size()) {
                if(right - left > len) {
                    start = left;
                    len = right - left;
                }
                //将字符d移除窗口
                char d = S.charAt(left);
                //右移窗口
                left++;
                if(need.containsKey(d)) {
                    if(window.get(d) == need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, len);
    }
}
