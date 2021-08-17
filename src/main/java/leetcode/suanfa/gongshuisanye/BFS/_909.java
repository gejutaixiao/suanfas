package leetcode.suanfa.gongshuisanye.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _909 {

    //909. 蛇梯棋
    int N;
    public int snakesAndLadders(int[][] board) {
        int res = -1;
        int step = 0;
        int n = board.length;
        N =n;
        int target = n * n;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        queue.add(1);
        vis.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) {
                    return step;
                }
                for (int k = 1; k <= 6; k++) {
                    int next = poll + k;
                    if (next > target) {
                        break;
                    }
                    int[] xy = getXY(next);
                    if (board[xy[0]][xy[1]] != -1 && !vis.contains(board[xy[0]][xy[1]])) {
                        vis.add(board[xy[0]][xy[1]]);
                        queue.add(board[xy[0]][xy[1]]);
                    } else {
                        vis.add(next);
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] getXY(int next) {
        int x = next / N;
        int y = next % N;
        x = N - x - 1;
        y = (N - x) % 2 == 1 ? y : N - y;
        return new int[]{x, y};
    }

    private int getNum(int dx, int dy) {
        if ((N - dx - 1) / 2 == 0) {
            return (N - dx - 1) * N + dy + 1;
        } else {
            return ((N - dx - 1)) * N + (N - dy);
        }
    }
}
