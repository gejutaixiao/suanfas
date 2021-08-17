package leetcode.suanfa.leetcode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _140 {

    //单词拆分Ⅱ
    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     *
     * 说明：
     *
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     *
     */

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return null;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        //nums中是所有可能的单词长度
        HashSet<Integer> nums = new HashSet<>();
        for (String s1 : wordDict) {
            nums.add(s1.length());
        }
        List<String> res = new ArrayList<>();
        dfs(0, nums, set, res, s.length(), "", s);
        return res;
    }

    private static void dfs(int i, HashSet<Integer> nums, HashSet<String> set, List<String> res, int len, String track, String str) {
        if (i == len) {
            res.add(track.trim());
            return;
        }
        for (Integer num : nums) {
            String tmp = track;
            if (num + i <= len) {
                String s = str.substring(i, i + num);
                if (set.contains(s)) {
                    track = track + " " + s;
                    dfs(i + num, nums, set, res, len, track, str);
                }
            }
            track = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> strings = wordBreak(s, wordDict);
        for (String string : strings) {
            System.out.println(string);
        }
//        System.out.println(s.substring(3, 6));
    }
}
