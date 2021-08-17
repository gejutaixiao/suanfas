package leetcode.suanfa.leetcode;

import java.util.Scanner;

public class _HJ7 {

    //取近似值
    public static int getInt(float f) {
        String s = String.valueOf(f);
        String[] str = s.split(".");
        char c = str[1].charAt(0);
        int res = Integer.parseInt(str[0]);
        boolean flag = false;
        if (c >= '5') {
            flag = true;
        } else {
            flag = false;
        }
        return flag == true ?  res + 1 : res;
    }
    public static void main(String[] args) {
        System.out.println(getInt(5.5f));
    }
}
