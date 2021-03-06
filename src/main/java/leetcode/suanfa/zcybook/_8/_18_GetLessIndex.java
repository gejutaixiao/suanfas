package leetcode.suanfa.zcybook._8;

public class _18_GetLessIndex {

    //在数组中找到局部最小的位置
    /**
     * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
     * arr的长度为N（N>1）时，如果arr[0]<arr[1],那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
     * 如果0<i<N-1,既有arr[i]<arr[i-1],又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
     */

    /**
     * 给定无序数组arr，已知arr中任意两个相邻的数不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {
        int N = arr.length;
        if (arr == null || N == 0) {
            return -1;  //不存在
        }
        if (N < 2 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int left = 1, right = N - 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
