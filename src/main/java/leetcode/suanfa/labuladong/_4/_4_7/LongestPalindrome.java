package leetcode.suanfa.labuladong._4._4_7;

public class LongestPalindrome {

    //最长回文子串
    public static String longestPalindrome(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            String s1 = palindRome(str, i, i);
            String s2 = palindRome(str, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String palindRome(String str, int i, int j) {
        int n = str.length();
        while (i >= 0 && j < n && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cabad"));
    }
}
