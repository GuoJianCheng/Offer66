package offer66;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution22_PrintBTFromUpToDown {
    /**
     * 题目：从上往下打印二叉树
     * 题干：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 解题思路：用队列去实现
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        /*if(root == null)   这种写法不行，即便是空的，也要返回一个空的ArrayList，而不是null
            return null;
        ArrayList<Integer> print = new ArrayList<Integer>();*/
        ArrayList<Integer> print = new ArrayList<Integer>();
        if(root == null)
            return print;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode tmp = deque.pop();
            print.add(tmp.val);
            if(tmp.left != null)
                deque.add(tmp.left);
            if(tmp.right != null)
                deque.add(tmp.right);
        }
        return print;
    }
}
