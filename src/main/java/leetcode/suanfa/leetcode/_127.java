package leetcode.suanfa.leetcode;

import java.util.*;

public class _127 {

    //单词接龙

    /**
     * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
     * <p>
     * 序列中第一个单词是 beginWord 。
     * 序列中最后一个单词是 endWord 。
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典 wordList 中的单词。
     * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
     * 如果不存在这样的转换序列，返回 0。
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        HashSet<String> vis = new HashSet<>(wordList);

        if (!vis.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        for (String s : wordList) {
            map.putIfAbsent(s, new LinkedList<>());
            for (String s1 : wordList) {
                if (help(s1, s)) {
                    map.get(s).add(s1);
                }
            }
        }
        vis = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        vis.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) {
                    return step;
                }
                for (String s : map.get(poll)) {
                    if (!vis.contains(s)) {
                        queue.add(s);
                        vis.add(s);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static boolean help(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit", "cog", list));
    }
}
