package leetcode.suanfa.leetcode;

public class _1812 {

    //判断国际象棋棋盘中一个格子的颜色
    /**
     * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
     *
     * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
     *
     */
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1);
        //表示奇数行
        return (x % 2 == 1) ? (y % 2 == 0) : (y % 2 == 1);
    }
}
