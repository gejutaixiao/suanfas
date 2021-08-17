package leetcode.suanfa.labuladong._1._1_4._1_4_4;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    //最长无重复子串
    /**
     * 给定一个字符串，请你找出其中不包含重复子串的最长字串长度
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(right < s.length()) {
            //将字符c加入窗口
            char c = s.charAt(right);
            //移动右窗口
            right++;
            //更新窗口内的数据
            window.put(c, window.getOrDefault(c, 0) + 1);
            //判断是否需要更新左窗口
            while(window.get(c) > 1) {
                //将字符d移出窗口
                char d = s.charAt(left);
                //移动左窗口
                left++;
                window.put(d, window.get(d) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
