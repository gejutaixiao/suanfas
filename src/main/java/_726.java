import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _726 {

    public static String countOfAtoms(String formula) {
        HashMap<String, Integer> map = help(formula);
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals("777")) continue;
            sb.append(key);
            Integer value = entry.getValue();
            if (value > 1) {
                sb.append(value);
            }
        }
        return sb.toString();
    }
    public static HashMap<String, Integer> help(String formula) {
        if (formula == null || formula.length() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        HashMap<String, Integer> help = new HashMap<>();
        Integer integer = 0;
        int len = 0;
        int num = 0;
        for (int i = 0; i < formula.length(); i++) {
            len++;
            char c = formula.charAt(i);
            if (c == '(') {
                help = help(formula.substring(i + 1));
                integer = help.get("777") + 1;
                i += integer;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c >= 'A' && c <= 'Z' && sb.length() > 0) {
                if (!help.isEmpty()) {
                    for (Map.Entry<String, Integer> en : help.entrySet()) {
                        String key = en.getKey();
                        if (key.equals("777")) continue;
                        map.put(key, map.getOrDefault(key, 0) + num * en.getValue());
                    }
                    help.clear();
                    continue;
                }
                for (int j = 1; j < num; j++) {
                    stack.push(sb.toString());
                }
                stack.push(sb.toString());
                sb = new StringBuffer();
                sb.append(c);
                num = 0;
            } else if (c == ')'){
                break;
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            for (int i = 1; i < num; i++) {
                stack.push(sb.toString());
            }
            stack.push(sb.toString());
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            map.put(pop, map.getOrDefault(pop, 0) + 1);
        }
        map.put("777", len + integer);
        return map;
    }

    public static void main(String[] args) {
        String formula = "(NB3)33";
        System.out.println(countOfAtoms(formula));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }
}