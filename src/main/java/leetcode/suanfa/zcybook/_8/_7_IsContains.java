package leetcode.suanfa.zcybook._8;

public class _7_IsContains {

    //在行列都排好序的矩阵中找数

    public static boolean isContains(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int x1 = 0, y1 = n - 1;
        while (x1 < m && y1 >= 0) {
            if (matrix[x1][y1] == k) {
                return true;
            } else if (matrix[x1][y1] > k) {
                y1--;
            } else {
                x1++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        System.out.println(isContains(matrix, 6));
    }
}
