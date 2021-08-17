package leetcode.suanfa.labuladong._4._4_9;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;

public class IsRectangleCover {

    //完美矩阵

    /**
     * 今天来看看力扣第 391 题「完美矩形」，题目会给我们输入一个数组 rectangles，里面装着若干四元组 (x1,y1,x2,y2)，每个四元组就是记录一个矩形的左下角和右上角坐标。
     * 也就是说，输入的 rectangles 数组实际上就是很多小矩形，题目要求我们输出一个布尔值，判断这些小矩形能否构成一个「完美矩形」。
     * @param rectangles
     * @return
     */
    public static boolean isRectangleCover(int[][] rectangles) {
        //先进行面积判断
        int totalArea = 0;
        //总矩阵的左下角
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        //总矩阵的右上角
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            x1 = Math.min(x1, rectangle[0]);
            y1 = Math.min(y1, rectangle[1]);
            x2 = Math.max(x2, rectangle[2]);
            y2 = Math.max(y2, rectangle[3]);
            totalArea += Math.abs(rectangle[2] - rectangle[0]) * Math.abs(rectangle[3] - rectangle[1]);
        }
        if ((x2 - x1) * (y2 - y1) != totalArea) {
            return false;
        }

        //再进行顶点判断
        HashSet<String> set = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int px1 = rectangle[0], py1 = rectangle[1];
            int px2 = rectangle[2], py2 = rectangle[3];
            for (int px : new int[]{px1, px2}) {
                for (int py : new int[]{py1, py2}) {
                    String xy = px + "," + py;
                    if (set.contains(xy)) {
                        set.remove(xy);
                    } else {
                        set.add(xy);
                    }
                }
            }
        }
        if (set.size() != 4 || !set.contains(x1 + "," + y1) || !set.contains(x1 + "," + y2) || !set.contains(x2 + "," + y1) || !set.contains(x2 + "," + y2)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(isRectangleCover(rectangles));
    }
}
