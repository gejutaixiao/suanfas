package leetcode.suanfa.labuladong._3._3_4._3_4_3;

public class Sort {

    //快速排序
    void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    //快速排序核心思想
    void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //通过交换元素构建分界点索引
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }
    int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > pivot) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 67, 1};
        Sort sort = new Sort();
        sort.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
