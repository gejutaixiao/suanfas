package leetcode.suanfa.labuladong._3._3_1._3_1_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    //组合
    /**
     * 输入两个数字 n, k，算法输出 [1..n] 中 k 个数字的所有组合。
     */

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(1, n, k, track);
        return res;
    }
    public static void dfs(int start, int n, int k, LinkedList<Integer> track) {
        if(k == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = start; i <= n; i++) {
            track.add(i);
            dfs(i + 1, n, k, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(10, 3);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
