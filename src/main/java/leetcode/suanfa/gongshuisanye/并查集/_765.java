package leetcode.suanfa.gongshuisanye.并查集;

public class _765 {

    //情侣牵手

    static int[] p;
    static void union1(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    static int find(int x) {
        while (p[x] != x) {
            x = p[x];
        }
        return x;
    }
    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n / 2;
        p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i += 2) {
            union1(row[i] / 2, row[i + 1] / 2);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p[i] == i) {
                count++;
            }
        }
        return m - count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 2};
        System.out.println(minSwapsCouples(nums));
    }
}
