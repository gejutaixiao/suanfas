package 笔试;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class huawei2 {

    public static int minStep(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        queue.add(n);
        vis.add(n);
        int step = 0;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll.equals(m)) {
                    return step;
                }
                int n1 = poll - 1;
                int n2 = poll + 1;
                int n3 = poll * 2;
                if (isValid(n1) && !vis.contains(n1)) {
                    vis.add(n1);
                    queue.add(n1);
                }
                if (isValid(n2) && !vis.contains(n2)) {
                    vis.add(n2);
                    queue.add(n2);
                }
                if (isValid(n3) && !vis.contains(n3)) {
                    vis.add(n3);
                    queue.add(n3);
                }
            }
            step++;
        }
        return step;
    }
    public static boolean isValid(int num) {
        if (num < 0 || num > 100000) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minStep(5, 17));
    }
}
