package leetcode.suanfa.leetcode;

public class _168 {

    //Excel表列名称
    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * 例如，
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * 示例 1:
     *
     * 输入: 1
     * 输出: "A"
     * 示例 2:
     *
     * 输入: 28
     * 输出: "AB"
     * 示例 3:
     *
     * 输入: 701
     * 输出: "ZY"
     *
     */
    public static String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (columnNumber > 0) {
            columnNumber--;
            stringBuffer.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " : " + convertToTitle(i));
        }
    }
}
