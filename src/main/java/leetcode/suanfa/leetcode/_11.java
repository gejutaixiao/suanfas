package leetcode.suanfa.leetcode;

import java.util.Random;

public class _11 {

    //盛水最多的容器

    public static int trap(int[] height) {
        int max = 0;
        int n = height.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int water = Math.min(height[i], height[j]) * (i - j);
                max = Math.max(max, water);
            }
        }
        return max;
    }

    public static int trap2(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        int l_max = height[0], r_max = height[height.length - 1];
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            max = Math.max(Math.min(l_max, r_max) * (right - left), max);
            if (l_max < r_max) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10; j++) {
                height[j] = random.nextInt(100);
            }
            int trap1 = trap(height);
            int trap2 = trap2(height);
            System.out.println(trap1 + " " + trap2);
            if (trap1 != trap2) {
                System.out.println("出现错误！！！");
                try {
                    throw new Exception("出现错误！！！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("执行成功");
    }
}
