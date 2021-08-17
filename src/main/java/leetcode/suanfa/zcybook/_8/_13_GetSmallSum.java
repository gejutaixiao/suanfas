package leetcode.suanfa.zcybook._8;

public class _13_GetSmallSum {

    //计算数组的小和

    public static int getSmallSum(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
        System.out.println(getSmallSum(arr));
    }
}
