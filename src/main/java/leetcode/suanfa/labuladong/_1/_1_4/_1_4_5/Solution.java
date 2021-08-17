package leetcode.suanfa.labuladong._1._1_4._1_4_5;

import java.util.HashMap;

public class Solution {

    //避开黑名单的随机数
    /**
     * 给你输入一个正整数 N，代表左闭右开区间 [0,N)，
     * 再给你输入一个数组 blacklist，其中包含一些「黑名单数字」，且 blacklist 中的数字都是区间 [0,N) 中的数字。
     * pick 函数会被多次调用，每次调用都要在区间 [0,N) 中「等概率随机」返回一个「不在 blacklist 中」的整数。
     */
    HashMap<Integer, Integer> blackMap;
    int sz;
    public Solution(int N, int[] blackList) {
        blackMap = new HashMap<>();
        sz = N - blackList.length;
        for(int n : blackList) {
            blackMap.put(n, 7);
        }
        int last = N - 1;
        for(int b : blackList) {
            //如果b已经在区间[sz,N)
            //直接跳过
            if(b >= sz) {
                continue;
            }
            //跳过黑名单中的数字
            while(blackMap.containsKey(last)) {
                last--;
            }
            //将黑名单中的所有数字索引到合法的数字上
            blackMap.put(b, last);
            last--;
        }
    }

    public int pick() {
        //随机选取一个索引
        int index = (int) (Math.random() * sz);
        //这个索引命中了黑名单
        //需要映射到其它索引
        if(blackMap.containsKey(index)) {
            return blackMap.get(index);
        }
        //没有命中黑名单，直接返回。
        return index;
    }

}

