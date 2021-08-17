package leetcode.suanfa.labuladong._1._1_3._1_3_3;

import java.util.LinkedHashMap;

public class LRU {

    //LRU缓存机制
    /**
     * LRU 缓存淘汰算法就是一种常用策略。
     * LRU 的全称是 Least Recently Used，
     * 也就是说我们认为最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。
     */

    int cap;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    public LRU(int cap) {
        this.cap = cap;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key);
    }
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            map.put(key, val);
            makeRecently(key);
            return;
        }
        if(cap <= map.size()) {
            int lastKey = map.keySet().iterator().next();
            map.remove(lastKey);
        }
        map.put(key, val);
    }
    public void makeRecently(int key) {
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}
