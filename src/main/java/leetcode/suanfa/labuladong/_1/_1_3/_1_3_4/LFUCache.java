package leetcode.suanfa.labuladong._1._1_3._1_3_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * LRU 算法的淘汰策略是 Least Recently Used，也就是每次淘汰那些最久没被使用的数据；
 * 而 LFU 算法的淘汰策略是 Least Frequently Used，也就是每次淘汰那些使用次数最少的数据
 */

public class LFUCache {
    int cap;
    int minFreq;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 构造容量为 capacity 的缓存
    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        keyToFreq = new HashMap<>();
        keyToVal = new HashMap<>();
        freqToKeys = new HashMap<>();
    }
    // 在缓存中查询 key
    public int get(int key) {
        if(!keyToVal.containsKey(key)) {
            return -1;
        }
        increase(key);
        return keyToVal.get(key);
    }
    // 将 key 和 val 存入缓存
    public void put(int key, int val) {
        if(keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increase(key);
            return;
        }
        if(this.cap <= keyToVal.size()) {
            removeMinUsed();
        }
        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void increase(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        if(freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if(freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
    public void removeMinUsed() {
        LinkedHashSet<Integer> hashSet = freqToKeys.get(minFreq);
        int deleteKey = hashSet.iterator().next();
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);
        hashSet.remove(deleteKey);
        if(hashSet.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
    }
}
