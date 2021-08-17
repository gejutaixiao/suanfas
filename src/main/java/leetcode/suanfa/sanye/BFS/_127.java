package leetcode.suanfa.sanye.BFS;

import sun.awt.image.ImageWatched;

import java.util.*;

public class _127 {

    //单词接龙
    static String s;
    static String e;
    static Set<String> set = new HashSet<>();
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        s = beginWord;
        e = endWord;
        for (String t : wordList) {
            set.add(t);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        int res = bfs();
        return res == 1 ? 0 : res + 1;
    }
    public static int bfs() {
        LinkedList<String> queue1 = new LinkedList<>();
        LinkedList<String> queue2 = new LinkedList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        queue1.add(s);
        queue2.add(e);
        map1.put(s, 0);
        map2.put(e, 0);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int t = -1;
            if (queue1.size() <= queue2.size()) {
                t = update(queue1, map1, map2);
            } else {
                t = update(queue2, map2, map1);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private static int update(LinkedList<String> q, HashMap<String, Integer> cur, HashMap<String, Integer> other) {
        String poll = q.pollFirst();
        int n = poll.length();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 26; k++) {
                String s1 = poll.substring(0, i) + String.valueOf((char)('a' + k)) + poll.substring(i + 1);
                if (set.contains(s1)) {
                    if (cur.containsKey(s1)) continue;
                    if (other.containsKey(s1)) {
                        return cur.get(poll) + other.get(s1) + 1;
                    } else {
                        cur.put(s1, cur.get(poll) + 1);
                        q.add(s1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(new String[]{"cog"});
        System.out.println(ladderLength("hog", "cog", strings));
    }
}
