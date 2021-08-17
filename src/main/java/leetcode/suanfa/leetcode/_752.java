package leetcode.suanfa.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _752 {

    //打开转盘锁
    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     */
    public static int openLock(String[] deadends, String target) {
        int step = 0;
        String str = null;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        queue.add("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                str = queue.poll();
                //判断是否和target一致
                if (str.equals(target)) {
                    return step;
                }
                for (int k = 0; k < 4; k++) {
                    String s = minusOne(str, k);
                    if (!visited.contains(s) && !dead.contains(s)) {
                        visited.add(s);
                        queue.add(s);
                    }
                    s = addOne(str, k);
                    if (!visited.contains(s) && !dead.contains(s)) {
                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    //向下转动转盘
    public static String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return String.valueOf(chars);
    }

    //向上转动转盘
    public static String addOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        /**
         * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
         * 输出：6
         *
         * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
         * 输出：-1
         *
         */
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String[] deadends2 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(openLock(deadends, "0202"));
        System.out.println(openLock(deadends2, "8888"));
    }
}
