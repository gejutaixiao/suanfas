package leetcode.suanfa.labuladong._4._4_4;

public class Multiply {

    //字符串相乘

    /**
     * 对于比较小的数字，做运算可以直接使用编程语言提供的运算符，但是如果相乘的两个因数非常大，语言提供的数据类型可能就会溢出。
     * 一种替代方案就是，运算数以字符串的形式输入，然后模仿我们小学学习的乘法算术过程计算出结果，并且也用字符串表示。
     * @param s1
     * @param s2
     * @return
     */
    public static String multiply(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2] + res[p1] * 10;
                res[p2] = sum % 10;
                res[p1] = sum / 10;
            }
        }
        //去除开头可能的0
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        String str = "";
        for (; i < res.length; i++) {
            str = str + res[i];
        }
        return str.length() == 0 ? "0" : str;
    }

    public static void main(String[] args) {
        System.out.println(multiply("99999", "9999999"));
    }
}
