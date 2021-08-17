package leetcode.suanfa.zcybook._1;

import java.util.Stack;

public class _9_MaxRecSize {

    //求最大子矩阵的大小
    /**
     * 给定一个整型矩阵map，其中只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
     * 1 0 1 1
     * 1 1 1 1
     * 1 1 1 0
     */

    public static int maxRecSize(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = map[i][j] == 0 ? 0 : heights[j] + 1;
            }
            max = Math.max(max, maxRectangle(heights));
        }
        return max;
    }
    public static int maxRectangle(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - k - 1) * heights[j];
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int area = (heights.length - k - 1) * heights[j];
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxRecSize(map));
    }
}
