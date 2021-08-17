package leetcode.suanfa.labuladong._1._1_4._1_4_4;

import java.util.HashMap;

public class CheckInclusion {

    //字符串排列
    /**
     * 给定两个字符串s1和s2，写一个函数来判断s2中是否包含s1的排列
     * 换句话说，第一个字符串的排列是第二个字符串的子串
     */

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int valid = 0;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(1), 0) + 1);
        }
        while(right < s2.length()) {
            //将字符c加入窗口
            char c = s2.charAt(right);
            //将窗口右移
            right++;
            //进行滑动窗口数据的更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c) == window.get(c)) {
                    valid++;
                }
            }
            //判断左窗口是否需要收缩
            while(right - left >= s1.length()) {
                if(valid == need.size()) {
                    return true;
                }
                //将c移出窗口
                c = s2.charAt(left);
                left++;
                if(need.containsKey(c)) {
                    if(need.get(c) == window.get(c)) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return false;
    }
}
