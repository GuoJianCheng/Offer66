package offer66;

import java.util.ArrayList;
import java.util.Stack;

public class Solution59_PrintBTWithZ {
    /**
     * 题目：按之字形顺序打印二叉树
     *
     * 题干：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     * 解题思路：定义两个栈,二叉树的奇数行从左到右压入第一个栈，二叉树的偶数行从右到左压入第二个栈
     * 也就是，当第一个栈弹出一个结点时，这个结点先将左孩子入第二个栈，再将右孩子入第二个栈
     * 当第二个栈弹出一个结点时，这个结点先将右孩子入第一个栈，再将左孩子入第一个栈
     * @param pRoot
     * @return
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)
            return result;

        ArrayList<Stack<TreeNode>> stackList = new ArrayList<Stack<TreeNode>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stackList.add(stack1);
        stackList.add(stack2);
        int index = 0;
        stackList.get(index).push(pRoot);

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!(stackList.get(0).empty() && stackList.get(1).empty())){
            TreeNode pNode = stackList.get(index).pop();
            if(index == 0){
                if(pNode.left != null)
                    stackList.get(1-index).push(pNode.left);
                if(pNode.right != null)
                    stackList.get(1-index).push(pNode.right);
            }else{
                if(pNode.right != null)
                    stackList.get(1-index).push(pNode.right);
                if(pNode.left != null)
                    stackList.get(1-index).push(pNode.left);
            }
            list.add(pNode.val);
            if(stackList.get(index).empty()){
                index = 1 - index;
                result.add((ArrayList<Integer>) list.clone());
                list.clear();
            }
        }

        return result;
    }
}
