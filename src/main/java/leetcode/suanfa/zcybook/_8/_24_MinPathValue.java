package leetcode.suanfa.zcybook._8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _24_MinPathValue {

    //求最短通路值

    /**
     * 用一个整型矩阵matrix表示一个网络，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右四个方向
     * 求从左上角到右下角的最短通路值。
     */

    public static int minPathValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] == 0) {
            return -1;
        }
        int[][] help = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        HashSet<String> vis = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 1;
        int size = 0;
        int m = matrix.length, n = matrix[0].length;
        String s = 0 + "_" + 0;
        String target = (m - 1) + "_" + (n - 1);
        queue.add(s);
        vis.add(s);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                s = queue.poll();
                if (s.equals(target)) {
                    return step;
                }
                String[] s1 = s.split("_");
                for (int j = 0; j < 4; j++) {
                    int x = Integer.parseInt(s1[0]) + help[j][0];
                    int y = Integer.parseInt(s1[1]) + help[j][1];
                    s = x + "_" + y;
                    if (x < 0 || y < 0 || x >= m || y >= n || vis.contains(s) || matrix[x][y] == 0) {
                        continue;
                    }
                    queue.add(s);
                    vis.add(s);

                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(minPathValue(matrix));
    }
}
