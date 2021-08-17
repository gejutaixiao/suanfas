package leetcode.suanfa.leetcode;

import java.util.PriorityQueue;

public class _329 {

    //最长递增路径
    /**
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
     *
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
     * 输出：4
     * 解释：最长递增路径为 [1, 2, 6, 9]。
     */

//    public int longestIncreasingPath(int[][] matrix) {
////        int m = matrix.length;
////        int n = matrix[0].length;
////        Pair[][] dp = new Pair[m][n];
////    }
}
class Pair {
    int len;
    int num;
    public Pair(int len, int num) {
        this.len = len;
        this.num = num;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
