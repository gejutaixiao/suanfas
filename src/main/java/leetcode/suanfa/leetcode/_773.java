package leetcode.suanfa.leetcode;

import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _773 {

    //滑动谜题
    /**
     * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
     *
     * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
     *
     * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
     *
     * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1
     *
     * 0    1   2
     * 3    4   5
     */
    //广度优先搜索
    public static int slidingPuzzle(int[][] board) {
        int[][] help = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};
        StringBuffer sb = new StringBuffer();
        for (int[] ints : board) {
            for (int anInt : ints) {
                sb.append(anInt);
            }
        }
        String s = sb.toString();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        queue.add(s);
        vis.add(s);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) {
                    return step;
                }
                int index = getIndex(poll);
                for (int i1 : help[index]) {
                    String swap = swap(poll, i1, index);
                    if (!vis.contains(swap)) {
                        vis.add(swap);
                        queue.add(swap);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private static int getIndex(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                index = i;
                break;
            }
        }
        return index;
    }
    public static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        //输入：board = [[1,2,3],[4,0,5]]
        //输出：1
        //解释：交换 0 和 5 ，1 步完成
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(slidingPuzzle(board));
    }
}
