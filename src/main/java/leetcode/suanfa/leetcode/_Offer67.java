package leetcode.suanfa.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

public class _Offer67 {

    //把字符串转换成整数

    public static int strToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        boolean isPositive = true;
        int num = 0;
        int right = 0;
        boolean flag = false;
        while (right < s.length()) {
            char c = s.charAt(right);
            if ((c != '-' && c != '+' || flag) && (c < '0' || c > '9')) {
                break;
            }
            if (c == '-' || c == '+') {
                flag = true;
                isPositive = c == '-' ? false : true;
            } else if (c >= '0' && c <= '9'){
                if (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && c > '7') {
                    return isPositive == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 - (c - '0');
                flag = true;
            }
            right++;
        }
        return isPositive == true ? -num : num;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("+42-"));
        System.out.println(strToInt("           --4   2"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("+91283472332"));
    }
}
