package leetcode.suanfa.labuladong._1._1_3._1_3_2;

public class EquationPossibleUF {

    /**
     * 给你一个数组 equations，装着若干字符串表示的算式。
     * 每个算式 equations[i] 长度都是 4，而且只有这两种情况：a==b 或者 a!=b，其中 a,b 可以是任意小写字母。
     * 你写一个算法，如果 equations 中所有算式都不会互相冲突，返回 true，否则返回 false。
     * 比如说，输入 ["a==b","b!=c","c==a"]，算法返回 false，因为这三个算式不可能同时正确。
     * 再比如，输入 ["c==c","b==d","x!=z"]，算法返回 true，因为这三个算式并不会造成逻辑冲突。
     */

    public boolean equationPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if(equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                uf.union(x, y);
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if(uf.connected(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
