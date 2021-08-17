package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _401 {

    //二进制手表
    //Integer.bitCount()
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    String s = "" + i + ":" + (j < 10 ? "0" + j : j);
                    res.add(s);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = readBinaryWatch(1);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
