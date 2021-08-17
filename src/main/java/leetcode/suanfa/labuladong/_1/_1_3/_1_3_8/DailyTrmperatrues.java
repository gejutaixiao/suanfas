package leetcode.suanfa.labuladong._1._1_3._1_3_8;

import java.util.Stack;

public class DailyTrmperatrues {

    //每日温度
    /**
     * 对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
     */

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int n = temperatures.length;
        int[] res= new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
        }
        return res;
    }
}
