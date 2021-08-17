package leetcode.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _Offer20 {

    //表示数值的字符串
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E' || s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'E') {
            return false;
        }
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (c == 'e' || c == 'E') {
                list.add(s.substring(left, right));
                left = right + 1;
            }
            right++;
        }
        list.add(s.substring(left, right));
        if (list.size() > 2) {
            return false;
        }
        if (list.size() == 1) {
            return number(list.get(0)) || smallNumber(list.get(0));
        }
        return (number(list.get(0)) || smallNumber(list.get(0))) && number(list.get(1));
    }

    //判断一个数是否是整数
    public static boolean number(String s) {
        int right = 0;
        boolean flag = false;
        boolean flag2 = false;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if ((c != '-' && c != '+' || flag) && (c < '0' || c > '9')) {
                return false;
            }
            if (c == '+' || c == '-') {
                flag = true;
            }
            if ((c >= '0' && c <= '9')) {
                flag = true;
                flag2 = true;
            }
        }
        return s.length() == 1 ? flag2 : true;
    }

    public static boolean smallNumber(String s) {
        int n = s.length();
        if (n == 1) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
        if (s.charAt(0) == '.') {
            for (int i = 1; i < n; i++) {
                if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    return false;
                }
            }
        } else if (s.charAt(n - 1) == '.') {
            return number(s.substring(0, n - 1));
        }
        int right = 0;
        boolean flag = false;
        boolean flag2 = false;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if ((c != '+' && c != '-' || flag) && (c < '0' || c > '9')  && (c != '.' || flag2)) {
                return false;
            }
//            if (c == '.' && flag2) {
//                return false;
//            }
            if (c == '+' || c == '-' || (c >= '0' && c <= '9')) {
                flag = true;
            }
            if (c == '.') {
                flag2 = true;
            }
        }
        // return s.length() == 1 ? !flag2 : true;
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)('a'));
        System.out.println((int)('A'));
    }

}
