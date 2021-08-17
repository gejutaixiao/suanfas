package leetcode.suanfa.labuladong._4._4_5;

public class StringToInteger {

    static int stringToInteger(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = num * 10 + (c - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("1231234"));
    }
}
