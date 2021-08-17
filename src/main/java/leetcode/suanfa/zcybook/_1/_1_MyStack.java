package leetcode.suanfa.zcybook._1;

import java.util.Stack;

public class _1_MyStack {

    //设计一个有getMin功能的栈
    //实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
    /**
     * 1.pop,push,getMin操作的时间复杂度都是O（1）
     * 2.设计的栈类型可以使用现有的栈结构
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public _1_MyStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (minStack.peek() >= val) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(val);
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        minStack.pop();
        return stack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return minStack.peek();
    }
}
