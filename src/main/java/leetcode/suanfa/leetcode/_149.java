package leetcode.suanfa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class _149 {

    //直线上最多的点数

    /**
     * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。
     * 求最多有多少个点在同一条直线上。
     * <p>
     * 1 <= points.length <= 300
     * points[i].length == 2
     * -104 <= xi, yi <= 104
     * points 中的所有点 互不相同
     * <p>
     * <p>
     * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出：4
     * <p>
     * [[-6,-1],[3,1],[12,3]]
     */

    public static int maxPoints1(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int n = points.length;
        for (int i = 0; i < points.length; i++) {
            if (max >= n - i || max > n / 2) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int help = help(Math.abs(x), Math.abs(y));
                    x /= help;
                    y /= help;
                }
                int s = y + x * 20001;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            int ret = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                ret = Math.max(ret, num + 1);
            }
            max = Math.max(max, ret);
            map.clear();
        }
        return max;
    }

    //去除两个数的最大公约数
    public static int help(int x, int y) {
        int min = Math.min(x, y);
        int max = 1;
        for (int i = 2; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    //a = 8, b = 4, help2(8, 4)
    //help2(4, 0) -> return 4
    public static int help2(int a, int b) {
        return b != 0 ? help2(b, a % b) : a;
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


    public static void main(String[] args) {
        //[[0,0],[4,5],[7,8],[8,9],[5,6],[3,4],[1,1]]
        //[[-6,-1],[3,1],[12,3]]
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//        int[][] point = {{0, 0}, {4, 5}, {7, 8}, {8, 9}, {5, 6}, {3, 4}, {1, 1}};
//        int[][] points = {{-6, -1}, {3, 1}, {12, 3}};
//        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        Random random = new Random();
        HashSet<String> set = new HashSet<>();
        int[][] points = new int[132][2];
        int k = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 132; j++) {
                int x = random.nextInt(200) * (random.nextInt(2) >= 1 ? 1 : -1);
                int y = random.nextInt(200) * (random.nextInt(2) >= 1 ? 1 : -1);
                String s = x + "_" + y;
                if (!set.contains(s)) {
                    points[j][0] = x;
                    points[j][1] = y;
                    set.add(s);
                } else {
                    int x1 = x + y;
                    int y1 = x - y;
                    points[j][0] = x1;
                    points[j][1] = y1;
                    set.add(x1 + "_" + y1);
                }
            }
            if (maxPoints(points) != maxPoints1(points)) {
                System.err.println("出现错误！！！" + k++);
            }
        }
        System.out.println("毫无问题！！！");


//        for (int i = 0; i < 10000; i++) {
//            int x = random.nextInt(1000) + 1;
//            int y = random.nextInt(1000) + 1;
//            if (gcd(x, y) != help(x, y)) {
//                System.err.println("出现错误！！！");
//                System.out.println(x + " " + y);
//            }
//        }
//        System.out.println("prefect！！！");

    }

}
