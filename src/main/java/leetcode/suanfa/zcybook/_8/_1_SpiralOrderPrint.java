package leetcode.suanfa.zcybook._8;

public class _1_SpiralOrderPrint {

    //转圈打印矩阵
    /**
     * 给定一个整型矩阵matrix, 请按照转圈的方式打印它
     *
     * 1    2   3   4
     * 5    6   7   8
     * 9    10  11  12
     * 13   14  15  16
     */

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (tR <= eR && tC <= eC) {
            spiralOrderPrint(matrix, tR++, tC++, eR--, eC--);
        }
    }

    private static void spiralOrderPrint(int[][] matrix, int tR, int tC, int eR, int eC) {
        if (tR == eR) {
            //只有一行
            for (int i = tC; i <= eC; i++) {
                System.out.println(matrix[tR][i] + " ");
            }
        } else if (tC == eC) {
            //只有一列
            for (int i = tR; i <= eR; i++) {
                System.out.println(matrix[i][tC] + " ");
            }
        } else {
            //一般情况
            int x1 = tC;
            while (x1 < eC) {
                System.out.println(matrix[tR][x1] + " ");
                x1++;
            }
            x1 = tR;
            while (x1 < eR) {
                System.out.println(matrix[x1][eC] + " ");
                x1++;
            }
            x1 = eC;
            while (x1 > tC) {
                System.out.println(matrix[eR][x1] + " ");
                x1--;
            }
            x1 = eR;
            while (x1 > tR) {
                System.out.println(matrix[x1][tC] + " ");
                x1--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }
}
