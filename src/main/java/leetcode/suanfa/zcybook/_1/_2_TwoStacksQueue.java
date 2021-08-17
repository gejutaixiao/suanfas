package leetcode.suanfa.zcybook._1;

import java.util.Stack;

public class _2_TwoStacksQueue {

    //由两个栈组成队列
    /**
     * 编写一个类，用两个栈实现队列，支持队列的基本操作（add,poll,peek)
     */

    Stack<Integer> stack;
    Stack<Integer> help;

    public _2_TwoStacksQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void add(int val) {
        stack.push(val);
    }

    public int poll() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Your queue is empty!");
        }
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        int res = help.pop();
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return res;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Your queue is empty!");
        }
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        int res = help.peek();
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return res;
    }
}
