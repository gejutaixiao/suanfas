package leetcode.suanfa.labuladong._3._3_1._3_1_4;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveSudoku {

    //解数独

    /**
     * 输入是一个9x9的棋盘，空白格子用点号字符 . 表示，算法需要在原地修改棋盘，将空白格子填上数字，得到一个可行解。
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    public static void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board.length;
        //base case
        //已经全部完成
        if(i == m) {
            return;
        }
        //当前行完成，去下一行
        if(j == n) {
            dfs(board, i + 1, 0);
        }
        //当前位置本来就有数字，不需要修改
        if(board[i][j] != '.') {
            dfs(board, i, j + 1);
        }
        for(char c = '1'; c <= '9'; c++) {
            if(!isValid(board, i, j, c)) {
                continue;
            }
            //做选择
            board[i][j] = c;
            dfs(board, i, j + 1);
            //撤销选择
            board[i][j] = '.';
        }
    }
    public static boolean isValid(char[][] board, int i, int j, char c) {
        for(int k = 0; k < 9; k++) {
            //判断当前行
            if(board[i][k] == c) {
                return false;
            }
            //判断当前列
            if(board[k][j] == c) {
                return false;
            }
            //判断3 * 3 矩阵内是否有相同数字
            if(board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == c) {
                return false;
            }
        }
        return true;
    }


    //所有数独
    static List<char[][]> res = new ArrayList<>();
    public static List<char[][]> solveSudoku() {
        char[][] track = new char[9][9];
        for (char[] chars : track) {
            Arrays.fill(chars, '.');
        }
        dfs2(track, 0, 0);
        return res;
    }
    public static boolean dfs2(char[][] track, int i, int j) {
        int m = track.length, n = track.length;
        //base case
        if(m == i) {
            char[][] list = new char[n][n];
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    list[x][y] = track[x][y];
                }
            }
            res.add(list);
            return true;
        }
        //到了当前行的最后一个位置
        if(j == n) {
            return dfs2(track, i + 1, 0);
        }
        if(track[i][j] != '.') {
            return dfs2(track, i, j + 1);
        }
        for(char c = '1'; c <= '9'; c++) {
            if(!isValidC(track, i, j, c)) {
                continue;
            }
            //做选择
            track[i][j] = c;
            if(dfs2(track, i, j + 1)) {
                return true;
            }
            //撤销选择
            track[i][j] = '.';
        }
        return false;
    }
    public static boolean isValidC(char[][] track, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            //判断当前行
            if(track[row][i] == c) return false;
            //判断当前列
            if(track[i][col] == c) return false;
            //判断当前3 * 3 方框内是否有重复值
            if(track[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) return false;
        }
        return true;
    }

    public static List<char[][]> solveSudoku2() {
        char[][] track = new char[9][9];
        for (char[] chars : track) {
            Arrays.fill(chars, '.');
        }
        dfs3(track, 0, 0);
        return res;
    }
    public static void dfs3(char[][] track, int i, int j) {
        int m = track.length, n = track.length;
        if(res.size() == 10000) {
            return;
        }
        //base case
        if(m == i) {
            char[][] list = new char[n][n];
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    list[x][y] = track[x][y];
                }
            }
            res.add(list);
            return;
        }
        //到了当前行的最后一个位置
        if(j == n) {
            dfs3(track, i + 1, 0);
            return;
        }
        if(track[i][j] != '.') {
            dfs3(track, i, j + 1);
            return;
        }
        for(char c = '1'; c <= '9'; c++) {
            if(!isValidC(track, i, j, c)) {
                continue;
            }
            //做选择
            track[i][j] = c;
            dfs3(track, i, j + 1);
            //撤销选择
            track[i][j] = '.';
        }
    }

    public static void main(String[] args) {
        List<char[][]> chars = solveSudoku2();
        for (char[][] aChar : chars) {
            for (char[] chars1 : aChar) {
                for (char c : chars1) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
