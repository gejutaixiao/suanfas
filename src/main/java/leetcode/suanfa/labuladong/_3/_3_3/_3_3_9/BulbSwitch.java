package leetcode.suanfa.labuladong._3._3_3._3_3_9;

public class BulbSwitch {

    //开关问题

    /**
     * 有 n 盏电灯，最开始时都是关着的。现在要进行 n 轮操作：
     * 第 1 轮操作是把每一盏电灯的开关按一下（全部打开）。
     * 第 2 轮操作是把每两盏灯的开关按一下（就是按第 2，4，6... 盏灯的开关，它们被关闭）。
     * 第 3 轮操作是把每三盏灯的开关按一下（就是按第 3，6，9... 盏灯的开关，有的被关闭，比如 3，有的被打开，比如 6）...
     * 如此往复，直到第 n 轮，即只按一下第 n 盏灯的开关。
     * 现在给你输入一个正整数 n 代表电灯的个数，问你经过 n 轮操作后，这些电灯有多少盏是亮的？
     * @param n
     * @return
     */
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
