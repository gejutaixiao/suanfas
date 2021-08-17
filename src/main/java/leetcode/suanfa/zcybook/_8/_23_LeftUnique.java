package leetcode.suanfa.zcybook._8;

public class _23_LeftUnique {

    //数组的partition调整
    //给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证右部分是否有序

    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0, right = 0;
        while (right < arr.length) {
            if (arr[left] != arr[right++]) {
                swap(++left, right - 1, arr);
            }
        }
    }

    private static void swap(int i, int i1, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 7};
        leftUnique(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
