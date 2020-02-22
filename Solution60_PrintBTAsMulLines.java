package offer66;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution60_PrintBTAsMulLines {
    /**
     * 题目：把二叉树打印成多行
     *
     * 题干：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * 解题思路：需要两个参数toBePrint（本层中剩余将要打印的结点）
     *                     nextLevelNodes(下一层中共有多少个结点)
     *          当toBePrint = 0时，就可以打印本层所有结点了
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)
            return result;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(pRoot);
        int toBePrint = 1;
        int nextLevelNodes = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!deque.isEmpty()){
            TreeNode pNode = deque.pop();
            toBePrint--;
            list.add(pNode.val);
            if(pNode.left != null){
                deque.add(pNode.left);
                nextLevelNodes++;
            }
            if(pNode.right != null){
                deque.add(pNode.right);
                nextLevelNodes++;
            }
            if (toBePrint == 0){
                result.add(new ArrayList<Integer>(list));
                list.clear();
                toBePrint = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return result;
    }
}
