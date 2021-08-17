package leetcode.suanfa.zcybook._8;

public class _17_MaxSum {

    //子矩阵的最大累加和问题
    public static int maxSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] m = null;
        for (int i = 0; i < matrix.length; i++) {
            m = new int[matrix.length];
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < m.length; k++) {
                    m[k] += matrix[j][k];
                }
                int maxSum = maxSum(m);
                max = Math.max(max, maxSum);
            }
        }
        return max;
    }

    public static int maxSum(int[] arr) {
        int dp_pre = arr[0];
        int dp_res = 0;
        for (int i = 1; i < arr.length; i++) {
            dp_res = Math.max(dp_pre + arr[i], arr[i]);
            dp_pre = dp_res;
        }
        return dp_pre;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(maxSum(matrix));
    }
}
