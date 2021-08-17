package leetcode.suanfa.gongshuisanye.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _752 {

    //打开转盘锁
    /**
     * 双向BFS
     * 1.创建两个队列分别用于两个方向的搜索；
     * 2.创建两个哈希表用于解决相同节点重复搜索和记录转换次数
     * 3.为了尽可能让两个搜索方向“平均”，每次从队列中取值进行扩展时，先判断哪个队列容量较少；
     * 4.如果在搜索过程中搜索到对方搜索过的节点，说明找到了最短路径。
     */

    String s;
    String t;
    HashSet<String> vis = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        s = "0000";
        t = target;
        if (s.equals(target)) return 0;
        for (String deadend : deadends) {
            vis.add(deadend);
        }
        if (vis.contains(s) || vis.contains(target)) return -1;
        int res = bfs();
        return res;
    }
    public int bfs() {
        Queue<String> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        HashMap<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        q1.add(s);
        map1.put(s, 0);
        q2.add(t);
        map2.put(t, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int t = -1;
            if (q1.size() < q2.size()) {
                t = update(q1, map1, map2);
            } else {
                t = update(q2, map2, map1);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private int update(Queue<String> queue, HashMap<String, Integer> cur, HashMap<String, Integer> other) {
        String poll = queue.poll();
        Integer step = cur.get(poll);
        String s;
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j <= 1; j++) {
                if (j == 0) continue;
                if (j == -1) {
                    s = add(poll, i);
                } else {
                    s = des(poll, i);
                }
                if (vis.contains(s)) continue;
                if (cur.containsKey(s)) continue;
                if (other.containsKey(s)) {
                    return step + 1 + other.get(s);
                }
                cur.put(s, step + 1);
                queue.add(s);
            }
        }
        return -1;
    }

    private String des(String poll, int i) {
        char[] chars = poll.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i]--;
        }
        return String.valueOf(chars);
    }

    private String add(String poll, int i) {
        char[] chars = poll.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i]++;
        }
        return String.valueOf(chars);
    }
}
