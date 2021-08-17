package leetcode.suanfa;

public class matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = matrix.length;
        for (int l = 1; l < n; l++) {
            for(int i = 0; i < n - l; i++) {
                int j = i + l;
                System.out.println(matrix[i][j]);
            }
        }
    }
}
