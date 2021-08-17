package leetcode.suanfa.labuladong._3._3_1._3_1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SloveNQueens {

    //N皇后问题
    /**
     * 给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击。
     * PS：皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
     */
    static List<char[][]> res = new ArrayList<>();
    public static List<char[][]> sloveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] strings : board) {
            Arrays.fill(strings, '.');
        }
        //从第0行开始遍历
        dfs(board, 0);
        return res;
    }
    public static void dfs(char[][] board, int m) {
        //base case
        if(m == board.length) {
            char[][] c = new char[m][m];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < m; j++) {
                    c[i][j] = board[i][j];
                }
            }
            res.add(c);
            return;
        }
        int n = board.length;
        for(int i = 0; i < n; i++) {
            if(!isValid(board, m, i)) {
                continue;
            }
            //做选择
            board[m][i] = 'Q';
            dfs(board, m + 1);
            //撤销选择
            board[m][i] = '.';
        }
    }
    public static boolean isValid(char[][] board, int i, int j) {
        int n = board.length;
        for(int k = 0; k < n; k++) {
            //验证同一行
            if(board[i][k] != '.') {
                return false;
            }
            //验证同一列
            if(board[k][j] != '.') {
                return false;
            }
        }
        //验证左上
        for(int left_i = i - 1, left_j = j - 1; left_i >= 0 && left_j >= 0; left_i--, left_j--) {
            if(board[left_i][left_j] != '.') {
                return false;
            }
        }
        //验证右上
        for(int right_i = i - 1, right_j = j + 1; right_i >= 0 && right_j < n; right_i--, right_j++) {
            if(board[right_i][right_j] != '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<char[][]> chars = sloveNQueens(18);
//        for (char[][] aChar : chars) {
//            for (char[] chars1 : aChar) {
//                for (char c : chars1) {
//                    System.out.print(c);
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//        }
        System.out.println(chars.size());
    }
}
