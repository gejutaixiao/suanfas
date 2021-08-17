package leetcode.suanfa.labuladong._3._3_2._3_2_1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {

    //打开转盘锁

    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        int depth = 0;
        queue.add(start);
        vis.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return depth;
                }
                for (int j = 0; j < 4; j++) {
                    String s1 = plusOne(poll, j);
                    if (!vis.contains(s1) && !dead.contains(s1)) {
                        vis.add(s1);
                        queue.add(s1);
                    }
                    s1 = minusOne(poll, j);
                    if (!vis.contains(s1) && !dead.contains(s1)) {
                        vis.add(s1);
                        queue.add(s1);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
    public static String plusOne(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }
    public static String minusOne(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

}
