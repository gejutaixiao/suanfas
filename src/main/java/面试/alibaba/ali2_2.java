package 面试.alibaba;

import java.util.Scanner;

public class ali2_2 {

    /**
6 9
1 2 3 3 2 1
2 6 3
1 1 1
1 6 1
2 3 6
2 1 6
1 6 3
1 1 3
2 1 3
2 6 3
     */
    static int[] p;
    static int[] size;
    static class UF {
        public UF(){}
        public int union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if (roota == rootb) {
                return -1;
            }
            int res = (roota + rootb) ^ Math.abs(size[roota] - size[rootb]);
            if (size[roota] > size[rootb]) {
                size[roota] += size[rootb];
                p[rootb] = p[roota];
            } else {
                size[rootb] += size[roota];
                p[roota] = p[rootb];
            }
            return res;
        }
        public int find(int x) {
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int num = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        p = new int[num + 1];
        size = new int[num + 1];
        UF uf = new UF();
        String[] str2 = sc.nextLine().split(" ");
        for (int i = 0; i < str2.length; i++) {
            p[i + 1] = i + 1;
            size[i + 1] = Integer.parseInt(str2[i]);
        }
        for (int i = 0; i < n; i++) {
            String[] str3 = sc.nextLine().split(" ");

            int t = Integer.parseInt(str3[0]);
            int a = Integer.parseInt(str3[1]);
            int b = Integer.parseInt(str3[2]);
            if (t == 1) {
                if (a != b) {
                    int union = uf.union(a, b);
                    if (union > 0) {
                        System.out.println(union);
                    }
                }
            } else {
                if (uf.connected(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
