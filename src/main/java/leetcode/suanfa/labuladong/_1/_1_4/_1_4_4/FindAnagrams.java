package leetcode.suanfa.labuladong._1._1_4._1_4_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {

    //找到所有字母异位
    /**
     * 给定一个字符串s和非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引
     */

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, valid = 0;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        while(right < s.length()) {
            //将字符c加入窗口
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            //判断是否需要移动左窗口
            while(right - left >= p.length()) {
                if(valid == need.size()) {
                    list.add(left);
                }
                //将字符d移除窗口
                char d = s.charAt(left);
                //移动左窗口
                left++;
                //进行窗口内的数据更新
                if(need.containsKey(d)) {
                    if(window.get(d) == need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return list;
    }
}
