package leetcode.suanfa.leetcode;

import java.util.*;

public class _611 {

    //有效的三角形个数
    /**
     * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
     *
     * 示例 1:
     * 输入: [2,2,3,4]
     * 输出: 3
     * 解释:
     * 有效的组合是:
     * 2,3,4 (使用第一个 2)
     * 2,3,4 (使用第二个 2)
     * 2,2,3
     *
     * 注意:
     * 数组长度不超过1000。
     * 数组里整数的范围为 [0, 1000]。
     *
     */
    static int res = 0;
    public static int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        LinkedList<Integer> track = new LinkedList<>();
        dfs(0, nums, track);
        return res;
    }

    private static void dfs(int i, int[] nums, LinkedList<Integer> track) {
        if (track.size() == 3 || i == nums.length) {
            if (help(track)) {
                res++;
            }
            return;
        }
        for (int k = i; k < nums.length; k++) {
            if (nums[k] == 0) {
                continue;
            }
            track.addLast(nums[k]);
            dfs(k + 1, nums, track);
            track.pollLast();
        }
    }

    private static boolean help(List<Integer> track) {
        int sum = 0;
        int max = 0;
        for (Integer integer : track) {
            sum += integer;
            max = Math.max(max, integer);
        }
        return sum > max * 2;
    }

    public static int triangleNumber2(int[] nums) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1 && nums[i] != 0; j++) {
                while (k < n && nums[k] < nums[j] + nums[i]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        Random random = new Random();
        int index = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                nums[j] = random.nextInt(100);
            }
            if (triangleNumber(nums) != triangleNumber2(nums)) {
                System.err.println("出现问题!!!" + index++);
            }
        }
        System.out.println("prefect!!!");
    }

}
