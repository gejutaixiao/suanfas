package leetcode.suanfa.leetcode;

import java.util.*;

public class _1418 {

    //点菜展示表

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
        TreeSet<String> set = new TreeSet<>();
        for (List<String> order : orders) {
            Integer integer = Integer.valueOf(order.get(1));
            String s = order.get(2);
            map.putIfAbsent(integer, new TreeMap<>());
            TreeMap<String, Integer> treeMap = map.get(integer);
            treeMap.put(s, treeMap.getOrDefault(s, 0) + 1);
            map.put(integer, treeMap);
            set.add(s);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("Table");
        for (String s : set) {
            list.add(s);
        }
        res.add(list);
        for (Map.Entry<Integer, TreeMap<String, Integer>> entry : map.entrySet()) {
            list = new ArrayList<>();
            TreeMap<String, Integer> value = entry.getValue();
            list.add(String.valueOf(entry.getKey()));
            for (String s : set) {
                if (value.containsKey(s)) {
                    list.add(String.valueOf(value.get(s)));
                } else {
                    list.add("0");
                }
            }
            res.add(list);
        }
        return res;
    }
}
