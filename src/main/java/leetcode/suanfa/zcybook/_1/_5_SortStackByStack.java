package leetcode.suanfa.zcybook._1;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

public class _5_SortStackByStack {

    //一个栈中的元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            while (!help.isEmpty() && help.peek() < val) {
                stack.push(help.pop());
            }
            help.push(val);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(2);
        stack.push(9);
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
