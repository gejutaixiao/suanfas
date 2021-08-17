package leetcode.suanfa.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _726 {

    //原子得数量
    public static String[] countO(String formula) {
        if (formula == null || formula.length() == 0) {
            return null;
        }
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String[] strings = {"", "0"};
        for (int i = 0; i < formula.length(); i++) {
            len++;
            char c = formula.charAt(i);
            if (c == '(') {
                strings = countO(formula.substring(i + 1));
                i += Integer.valueOf(strings[1]);
                sb = new StringBuffer(strings[0]);
            }
            if (c >= '2' && c <= '9') {
                for (int j = 0; j < c - '0'; j++) {
                    String s = sb.toString();
                    StringBuffer sb2 = new StringBuffer();
                    for (char c1 : s.toCharArray()) {
                        if (c1 >= 'A' && c <= 'Z' && sb.length() > 0) {

                        }
                    }
                }
                sb = new StringBuffer();
            } else if (c >= 'A' && c <= 'Z' && sb.length() > 0) {
                stack.push(sb.toString());
                sb = new StringBuffer();
                sb.append(c);
            } else {
                sb.append(c);
            }
            if (c == ')') {
                break;
            }
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            map.put(pop, map.getOrDefault(pop, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            Integer entryValue = entry.getValue();
            if (entryValue > 1) sb.append(entryValue);
        }
        return new String[]{sb.toString(), String.valueOf(len + Integer.valueOf(strings[1]))};
    }

    public static void main(String[] args) {
        String formula = "H2OHo3";
        System.out.println(countO(formula)[0]);
    }
}
