package leetcode.suanfa.zcybook._8;

public class _2_Rotate {

    //将正方形矩阵顺时针转动90°
    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * 7 4 1
     * 8 5 2
     * 9 6 3
     */

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (tR < eR) {
            rotate(matrix, tR++, tC++, eR--, eC--);
        }
    }

    private static void rotate(int[][] matrix, int tR, int tC, int eR, int eC) {
        int times = eC - tC;
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[eR - i][tC];
            matrix[eR - i][tC] = matrix[eR][eC - i];
            matrix[eR][eC - i] = matrix[tR + i][eC];
            matrix[tR + i][eC] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
}
