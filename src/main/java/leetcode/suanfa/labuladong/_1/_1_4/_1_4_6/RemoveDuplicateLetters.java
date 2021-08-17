package leetcode.suanfa.labuladong._1._1_4._1_4_6;

import java.util.Stack;

public class RemoveDuplicateLetters {

    //去除重复字母
    /**
     * 给你一个仅包含小写字母的字符串，请你去除字符串中包含的重复字母，保证每个字母仅出现一次，并且返回的结果字典序最小
     */

    public String removeDuplicateLetters(String str) {
        //记录每个字母出现的次数
        int[] count = new int[256];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        //记录每个字母是否在结果中出现
        boolean[] inStack = new boolean[256];
        //用类似最小栈结构来存储字母
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            //当前遍历到的字符
            char c = str.charAt(i);
            //c的个数减一
            count[c]--;
            //判断栈中是否含有c
            if(inStack[c]) {
                continue;
            }
            //将栈中比c的字典序大的字符出栈
            while(!stack.isEmpty() && stack.peek() > c) {
                //判断后面是否还有stack.peek()元素
                //如果没有则不出栈
                if(count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters(str));
    }
}
