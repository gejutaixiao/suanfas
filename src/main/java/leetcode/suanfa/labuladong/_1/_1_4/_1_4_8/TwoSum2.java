package leetcode.suanfa.labuladong._1._1_4._1_4_8;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum2 {

    //两数之和Ⅱ
    //向数据结构中添加一个数number
    HashMap<Integer, Integer> freq = new HashMap<>();
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    //寻找当前数据结构中是否存在两个数的和为value
    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int other = value - key;
            if(other == key && freq.get(key) > 1) {
                return true;
            }
            if(other != key && freq.containsKey(other)) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    HashSet<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();
    public void add(int number) {
        for(int i : nums) {
            sum.add(i + number);
        }
        nums.add(number);
    }
    public boolean find(int value) {
        return sum.contains(value);
    }
}