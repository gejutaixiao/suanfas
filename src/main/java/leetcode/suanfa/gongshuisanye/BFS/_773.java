package leetcode.suanfa.gongshuisanye.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _773 {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int[][] matrix = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3 ,5}, {2, 4}};
        String start = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        queue.add(start);
        vis.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return step;
                }
                int index = 0;
                for (int k = 0; k < 6; k++) {
                    if (poll.charAt(k) == '0') {
                        index = k;
                        break;
                    }
                }
                for (int matrix1 : matrix[index]) {
                    String s = swap(poll, index, matrix1);
                    if (!vis.contains(s)) {
                        vis.add(s);
                        queue.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String poll, int index, int matrix1) {
        char[] chars = poll.toCharArray();
        char c = chars[index];
        chars[index] = chars[matrix1];
        chars[matrix1] = c;
        return String.valueOf(chars);
    }
}
