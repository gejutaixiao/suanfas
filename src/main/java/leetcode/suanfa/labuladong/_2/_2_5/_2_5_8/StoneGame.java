package leetcode.suanfa.labuladong._2._2_5._2_5_8;

import java.io.File;

public class StoneGame {

    //石子游戏
    /**
     * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
     * 你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
     *
     * 石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。
     * 比如有三堆石头 piles = [1, 100, 3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。
     *
     * 假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。
     * 比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。
     */

    //1.三维数组
    public static int stoneGame1(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        //base case 只有一堆石子
        for(int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                int left = dp[i + 1][j][1] + piles[i];
                int right = dp[i][j - 1][1] + piles[j];
                if(left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n - 1][0] - dp[0][n - 1][1];
    }


    //2.辅助类
    public static int stoneGame2(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        //base case
        for(int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
        }
        for(int l = 1; l < n; l++) {
            for(int i = 0; i < n - l; i++) {
                int j = i + l;
                int left = dp[i + 1][j].sec + piles[i];
                int right = dp[i][j - 1].sec + piles[j];
                if(left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair pair = dp[0][n - 1];
        return pair.fir - pair.sec;
    }

    public static void main(String[] args) {
        int[] piles = {3, 9, 1, 2};
        System.out.println(stoneGame2(piles));
    }


}

class Pair {
    int fir;
    int sec;
    public Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }
}
