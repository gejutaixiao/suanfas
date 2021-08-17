package leetcode.suanfa.labuladong._1._1_3._1_3_5;

import java.util.HashMap;
import java.util.Stack;

public class FreqStack {

    //最大栈
    int maxFreq;
    HashMap<Integer, Integer> valToFreq;
    HashMap<Integer, Stack<Integer>> freqToVals;
    public FreqStack() {
        valToFreq = new HashMap<>();
        freqToVals = new HashMap<>();
    }
    // 在栈中加入一个元素 val
    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    // 从栈中删除并返回出现频率最高的元素
    // 如果频率最高的元素不止一个，
    // 则返回最近添加的那个元素
    public int pop() {
        Integer remove = freqToVals.get(maxFreq).pop();
        valToFreq.put(remove, valToFreq.get(remove) - 1);
        if(freqToVals.get(maxFreq).isEmpty()) {
            freqToVals.remove(maxFreq);
            maxFreq--;
        }
        return remove;
    }
}
