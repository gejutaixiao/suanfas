package leetcode.suanfa.labuladong._3._3_3._3_3_9;

public class CanWinNim {

    //Nim石子游戏
    /**
     * 你和你的朋友面前有一堆石子，你们轮流拿，一次至少拿一颗，最多拿三颗，谁拿走最后一颗石子谁获胜。
     * 假设你们都很聪明，由你第一个开始拿，请你写一个算法，输入一个正整数 n，返回你是否能赢（true 或 false）。
     * 比如现在有 4 颗石子，算法应该返回 false。因为无论你拿 1 颗 2 颗还是 3 颗，对方都能一次性拿完，拿走最后一颗石子，所以你一定会输。
     */

    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
