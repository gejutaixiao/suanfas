package leetcode.suanfa.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _542 {

    //01矩阵

    /**
     * 542. 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     * <p>
     * 示例 1：
     * 输入：
     * [[0,0,0],
     * [0,1,0],
     * [0,0,0]]
     * <p>
     * 输出：
     * [[0,0,0],
     * [0,1,0],
     * [0,0,0]]
     */
    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return null;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        HashMap<String, Integer> map = new HashMap<>();

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 1, 0}, {1, 1, 1}};
        int[][] ints = updateMatrix(mat);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
