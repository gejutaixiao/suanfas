package 笔试.alibaba;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _ali2 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();
    public static String ali2_2(int a, int b) {
        if (!set.contains(a) || !set.contains(b)) {
            return "NO";
        }
        return "YES";
    }

    public static int ali2_1(int a, int b) {
        if (set.contains(a) && set.contains(b)) {
            return -1;
        }
        int min = 1;
        for (int i : set) {
            min = Math.min(i, min);
        }
        int p1 = 0;
        int p2 = 0;
        int res = 0;
        if (set.contains(a)) {
            p1 = map.get(min);
            p2 = map.get(b);
            res = (min + b) ^ Math.abs(p1 - p2);
            map.put(b, p1 + p2);
        } else {
            p1 = map.get(min);
            p2 = map.get(a);
            res = (min + a) ^ Math.abs(p1 - p2);
            map.put(a, p1 + p2);
        }
        set.add(a);
        set.add(b);
        for (int key : set) {
            map.put(key, p1 + p2);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int num = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        String[] str2 = sc.nextLine().split(" ");
        for (int i = 0; i < str2.length; i++) {
            map.put(i + 1, Integer.parseInt(str2[i]));
        }
        for (int i = 0; i < n; i++) {
            String[] str3 = sc.nextLine().split(" ");

            int t = Integer.parseInt(str3[0]);
            int a = Integer.parseInt(str3[1]);
            int b = Integer.parseInt(str3[2]);

            if (t == 1) {
                if (a == b) {
                    continue;
                }
                int res = ali2_1(a, b);
                if (res > 0) {
                    System.out.println(res);
                }
            } else {
                System.out.println(ali2_2(a, b));
            }
        }
    }
}
