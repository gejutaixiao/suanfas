package leetcode.suanfa.zcybook._8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _20_PrintTopK {

    //打印N个数组整体最大TopK

    public static void printTopK(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new RuntimeException("matrix is empty!");
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                priorityQueue.add(matrix[i][j]);
                while (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{123, 21, 13}, {4123, 53, 134}, {1, 2, 3}};
        printTopK(matrix, 4);
    }
}
