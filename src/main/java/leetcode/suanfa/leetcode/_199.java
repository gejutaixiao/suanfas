package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

public class _199 {

    //二叉树的右视图
    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。


    //广度优先遍历
    public List<Integer> rightSideViewBFS(TreeNode root) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        int depth = 0;
        int max_depth = -1;
        nodeQueue.add(root);
        depthQueue.add(depth);
        while(!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.remove();
            depth = depthQueue.remove();

            if(temp != null) {
                //获得二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                //将当前深度的节点放入map中
                map.put(depth, temp);
                nodeQueue.add(temp.right);
                nodeQueue.add(temp.left);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i <= depth; i++) {
            res.add(map.get(i).val);
        }
        return res;
    }

    //深度优先遍历
    public List<Integer> rightSideViewDFS(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int depth = 0;
        int max_depth = -1;
        nodeStack.push(root);
        depthStack.push(depth);
        TreeNode temp = null;
        while(!nodeStack.isEmpty()) {
            temp = nodeStack.pop();
            depth = depthStack.pop();
            if(temp != null) {
                max_depth = Math.max(max_depth, depth);
                if(!map.containsKey(depth)) {
                    map.put(depth, temp.val);
                }
                nodeStack.push(temp.left);
                nodeStack.push(temp.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i <= max_depth; i++) {
            res.add(map.get(i));
        }
        return res;
    }

}
