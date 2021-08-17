package leetcode.suanfa.labuladong._2._2_5._2_5_3;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FindRotateSteps {

    //自由之路
    /**
     * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
     *
     * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
     *
     * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
     *
     * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
     *
     * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
     * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
     *
     */

    //1.暴力递归
    public static int findRotateSteps1 (String ring, String key) {
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).addLast(i);
        }
        return dp(ring, 0, key, 0, map, ring.length());
    }
    public static int dp(String ring, int i, String key, int j, HashMap<Character, LinkedList<Integer>> map, int n) {
        //base case
        if(j == key.length()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (Integer index : map.get(key.charAt(j))) {
            //获得距离下一个字符的步数
            int step = Math.abs(i - index);
            //顺时针还是逆时针
            step = Math.min(step, n - step);
            //获得剩余所需的步数
            int dp2 = dp(ring, index, key, j + 1, map, n);
            res = Math.min(res, 1 + step + dp2);
        }
        return res;
    }

    //2.备忘录优化
    public static int findRotateSteps2(String ring, String key) {
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).addLast(i);
        }
        int[][] memo = new int[ring.length()][key.length()];
        return dp(ring, 0, key, 0, map, memo);
    }
    public static int dp(String ring, int i, String key, int j, HashMap<Character, LinkedList<Integer>> map, int[][] memo) {
        //base case
        if(j == key.length()) {
            return 0;
        }
        if(memo[i][j] != 0) {
            return memo[i][j];
        }
        int n = ring.length();
        int res = Integer.MAX_VALUE;
        for (Integer index : map.get(key.charAt(j))) {
            //获取当前指针到下一个字符的距离
            int step = Math.abs(i - index);
            //顺时针还是逆时针
            step = Math.min(step, n - step);
            //获得剩余字符串需要的步数
            int dp2 = dp(ring, index, key, j + 1, map, memo);
            res = Math.min(res, 1 + step + dp2);
        }
        memo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(findRotateSteps2(ring, key));
    }
}
