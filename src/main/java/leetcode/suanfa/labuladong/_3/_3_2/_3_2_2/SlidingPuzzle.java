package leetcode.suanfa.labuladong._3._3_2._3_2_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle {

    //滑动谜题
    /**
     * 给你一个 2x3 的滑动拼图，用一个 2x3 的数组board表示。
     * 拼图中有数字 0~5 六个数，其中数字 0 就表示那个空着的格子，你可以移动其中的数字，当board变为[[1,2,3],[4,5,0]]时，赢得游戏。
     *
     * 请你写一个算法，计算赢得游戏需要的最少移动次数，如果不能赢得游戏，返回 -1。
     */

    /**
     * 1 2 3
     * 4 5 0
     * {1, 3}
     * {0, 4, 2}
     * {1, 5}
     * {0, 4}
     * {3, 1, 5}
     * {2, 4}
     *
     * @param board
     * @return
     */
    public static int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        String start = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += board[i][j];
            }
        }
        String target = "123450";
        ArrayList<int[]> index = new ArrayList<>();
        index.add(new int[]{1, 3});
        index.add(new int[]{0, 4, 2});
        index.add(new int[]{1, 5});
        index.add(new int[]{0, 4});
        index.add(new int[]{3, 1, 5});
        index.add(new int[]{2, 4});
        Queue<String> queue = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        queue.add(start);
        vis.add(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return depth;
                }
                int idx = 0;
                for (int j = 0; j < poll.length(); j++) {
                    if (poll.charAt(j) == '0') {
                        idx = j;
                        break;
                    }
                }
                for (int i1 : index.get(idx)) {
                    String tmp = swap(poll, i1, idx);
                    if (!vis.contains(tmp)) {
                        vis.add(tmp);
                        queue.add(tmp);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
    public static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }

    public static void main(String[] args) {
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(slidingPuzzle(board));
    }
}
