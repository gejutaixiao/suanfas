package leetcode.suanfa.zcybook._5;

public class _1_IsDeformation {

    //判断两个字符串是否互为变形词
    /**
     * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，那么str1与str2互为变形词。
     * 请实现函数判断两个字符串是否互为变形词。
     */
    public static boolean isDeformation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] bo = new int[256];
        for (char c : str1.toCharArray()) {
            bo[c]++;
        }
        for (char c : str2.toCharArray()) {
            if (bo[c]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
