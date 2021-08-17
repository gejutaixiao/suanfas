package leetcode.suanfa.zcybook._8;

import javax.xml.stream.FactoryConfigurationError;

public class _3_PrintMatrixZigZag {

    //"之"字形打印矩阵
    /**
     * 给定一个矩阵matrix，按照"之"字形的方式打印这个矩阵
     * 1    2   3   4
     * 5    6   7   8
     * 9    10  11  12
     *
     * 1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12
     */

    public static void printMatrixZigZag(int[][] matrix) {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        int eR = matrix.length - 1, eC = matrix[0].length - 1;
        boolean flag = false;
        while (x2 <= eR) {
            printMatrixZigZag(matrix, x1, y1, x2, y2, flag);
            y1 = x1 == eR ? y1 + 1 : y1;
            x1 = x1 == eR ? x1 : x1 + 1;

            x2 = y2 == eC ? x2 + 1 : x2;
            y2 = y2 == eC ? y2 : y2 + 1;
            flag = !flag;
        }
    }

    private static void printMatrixZigZag(int[][] matrix, int x1, int y1, int x2, int y2, boolean flag) {
        if (flag) {
            //向下打印
            while (x2 <= x1) {
                System.out.println(matrix[x2++][y2--]);
            }
        } else {
            //向上打印
            while (y2 >= y1) {
                System.out.println(matrix[x1--][y1++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }
}
