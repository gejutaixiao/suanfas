package leetcode.suanfa.leetcode;

import leetcode.suanfa.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _501 {

    //二叉搜索树中的众数
    //https://leetcode-cn.com/tag/tree/problemset/

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     * 提示：如果众数超过1个，不需考虑输出顺序
     *
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     */
//    List<Integer> answer = new ArrayList<Integer>();
//    int base, count, maxCount;
//
//    public int[] findMode(TreeNode root) {
//        dfs(root);
//        int[] mode = new int[answer.size()];
//        for (int i = 0; i < answer.size(); ++i) {
//            mode[i] = answer.get(i);
//        }
//        return mode;
//    }
//
//    public void dfs(TreeNode o) {
//        if (o == null) {
//            return;
//        }
//        dfs(o.left);
//        update(o.val);
//        dfs(o.right);
//    }
//
//    public void update(int x) {
//        if (x == base) {
//            ++count;
//        } else {
//            count = 1;
//            base = x;
//        }
//        if (count == maxCount) {
//            answer.add(base);
//        }
//        if (count > maxCount) {
//            maxCount = count;
//            answer.clear();
//            answer.add(base);
//        }
//    }

    List<Integer> list = new ArrayList<>();
    int base, count, maxCount;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }
    public void update(int x) {
        if(base == x) {
            count++;
        } else {
            base = x;
            count = 1;
        }
        if(count == maxCount) {
            list.add(base);
        }
        if(count > maxCount) {
            list.clear();;
            maxCount = count;
            list.add(base);
        }
    }
}
