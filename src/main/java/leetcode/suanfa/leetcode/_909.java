package leetcode.suanfa.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class _909 {

    /**
     * N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
     * <p>
     * 例如，一块 6 x 6 大小的棋盘，编号如下：
     * <p>
     * 36  35  34  33  32  31
     * 25  26  27  28  29  30
     * 24  23  22  21  20  19
     * 13  14  15  16  17  18
     * 12  11  10  9   8   7
     * 1   2   3   4   5   6
     * <p>
     * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
     * <p>
     * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
     * <p>
     * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
     * <p>
     * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
     * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
     * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。 
     * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
     * <p>
     * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
     */


    public static int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        int m = board.length;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int step = 1;
        int size = 0;
        int[] xy = null;
        int x;
        int y;
        int poll;
        int target = m * m;
        for (int i = 2; i <= 7; i++) {
            if (i > target) {
                break;
            }
            xy = getXY(i, m);
            x = xy[0];
            y = xy[1];
            if (board[x][y] != -1) {
                if (!set.contains(board[x][y])) {
                    queue.add(board[x][y]);
                    set.add(board[x][y]);
                }
            } else {
                queue.add(i);
            }
            set.add(i);
        }
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if (poll == target) {
                    return step;
                }
                for (int k = 1; k <= 6; k++) {
                    int num = k + poll;
                    if (num > target) {
                        break;
                    } else {
                        xy = getXY(num, m);
                        x = xy[0];
                        y = xy[1];
                        if (board[x][y] != -1) {
                            if (!set.contains(board[x][y])) {
                                queue.add(board[x][y]);
                                set.add(num);
                            }
                        } else if (!set.contains(num)) {
                            queue.add(num);
                            set.add(num);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static int snakesAndLadders2(int[][] board) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int size = 0;
        int step = 0;
        int n = board.length;
        int target = n * n;
        int poll = 0;
        queue.add(1);
        set.add(1);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if (poll == target) {
                    return step;
                }
                for (int k = 1; k <= 6; k++) {
                    int num = poll + k;
                    if (num > target) {
                        break;
                    }
                    int[] xy = getXY(num, n);
                    if (board[xy[0]][xy[1]] != -1) {
                        num = board[xy[0]][xy[1]];
                    }
                    if (!set.contains(num)) {
                        set.add(num);
                        queue.add(num);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 7    8   9            0
     * 6    5   4            1
     * 1    2   3            2
     * <p>
     * 16   15  14  13       0
     * 9    10  11  12       1
     * 8    7   6   5        2
     * 1    2   3   4        3
     */
    private static int[] getXY(int num, int m) {
        num -= 1;
        int x = num / m;
        int y = num % m;
        x = m - x - 1;
        //flag == true,表明最后一行是奇数行，否则为偶数行
        boolean flag = (m - 1) % 2 == 1;
        boolean xy = x % 2 == 1;
        y = flag == xy ? y : m - y - 1;
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(19) + 2;
            int[][] board = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (x == 0 && y == 0) {
                        board[x][y] = -1;
                    } else {
                        board[x][y] = random.nextInt(100) <= 80 ? -1 : random.nextInt(n) + 1;
                    }
                }
            }
            int x1 = snakesAndLadders(board), x2 = snakesAndLadders2(board);
            if (x1 != x2) {
                System.err.println(x1 + "   " + x2);
            }
        }
        System.out.println("prefect!!!");

    }


    /**
     * 输入：[
     * [-1,-1,-1,-1,-1,-1],
     * [-1,-1,-1,-1,-1,-1],
     * [-1,-1,-1,-1,-1,-1],
     * [-1,35,-1,-1,13,-1],
     * [-1,-1,-1,-1,-1,-1],
     * [-1,15,-1,-1,-1,-1]]
     * 输出：4
     * 解释：
     * 首先，从方格 1 [第 5 行，第 0 列] 开始。
     * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
     * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
     * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
     * 然后你决定移动到方格 36, 游戏结束。
     * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
     *
     */
}
