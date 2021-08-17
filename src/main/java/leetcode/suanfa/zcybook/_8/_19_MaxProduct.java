package leetcode.suanfa.zcybook._8;

public class _19_MaxProduct {

    //数组中子数组的最大累乘积
    /**
     * 给定一个double类型的数组arr，其中元素可正、可负、可0，返回子数组累乘的最大乘积。
     * arr=[-2.5, 4, 0, 3, 0.5, 8, -1]
     * 子数组[3, 0.5, 8]累乘可以获得最大的乘积12，所以返回12
     */

    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        double res = Double.MIN_VALUE;
        double max = 1, min = 1;
        for (int i = 0; i < arr.length; i++) {
            double x1 = arr[i] * max;
            double x2 = arr[i] * min;
            max = Math.max(arr[i], Math.max(x1, x2));
            min = Math.min(arr[i], Math.min(x1, x2));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxProduct(arr));
    }
}
