package leetcode.suanfa.gongshuisanye.并查集;

public class meituan4 {
    static int[] p;
    static void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    static int find(int x) {
        while (p[x] != x) {
            p[x] = find(x);
        }
        return p[x];
    }
    public static int _4(int[] nums) {
        int n = nums.length / 2;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        p = new int[max + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(nums[i], nums[n + i]);
        }
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == i) {
                count++;
            }
        }
        return p.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 8, 6, 10, 1, 5, 8, 3};
        System.out.println(_4(nums));
    }
}
