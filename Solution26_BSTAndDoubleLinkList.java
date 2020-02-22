package offer66;

import java.util.Stack;

public class Solution26_BSTAndDoubleLinkList {
    /**
     * 题目：二叉搜索树与双向链表
     * 题干：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * 解题思路：1.辅助栈，将二叉搜索树中序遍历进栈中，然后在栈中调整指针，得到双向链表
     * 2.递归，中序遍历
     * @param pRootOfTree
     * @return
     */
    /*1.辅助栈，将二叉搜索树中序遍历进栈中，然后在栈中调整指针，得到双向链表
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Inorder(pRootOfTree);
        TreeNode doubleLinkListHead = null;
        stack.peek().right = null;
        while(true){
            if(stack.size() == 1){
                doubleLinkListHead = stack.pop();
                break;
            }
            TreeNode node = stack.pop();
            node.left = stack.peek();
            stack.peek().right = node;
        }
        doubleLinkListHead.left = null;
        return doubleLinkListHead;
    }

    public void Inorder(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return ;
        Inorder(pRootOfTree.left);
        stack.push(pRootOfTree);
        Inorder(pRootOfTree.right);
    }*/


    //2.递归，中序遍历
    TreeNode pLastNodeInList = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        ConvertNode(pRootOfTree);

        TreeNode pHeadOfList = pLastNodeInList;
        while(pHeadOfList != null && pHeadOfList.left != null)
            pHeadOfList = pHeadOfList.left;
        return pHeadOfList;
    }

    public void ConvertNode(TreeNode pRootOfTree){
        //其实就是一个中序遍历，
        //注意！！！这里有坑，是因为忘了形参不能传值，若传入参数里多加一个pLastNodeInList的话，
        //如ConvertNode(TreeNode pRootOfTree,TreeNode pLastNodeInList)，这样是传值，不能返回给调用者pLastNodeInList这个值
        //将pLastNodeInList设为全局变量才行！！！
        if(pRootOfTree == null)
            return ;

        if(pRootOfTree.left != null)
            ConvertNode(pRootOfTree.left);

        pRootOfTree.left = pLastNodeInList;
        if(pLastNodeInList != null)
            pLastNodeInList.right = pRootOfTree;
        pLastNodeInList = pRootOfTree;

        if(pRootOfTree.right != null)
            ConvertNode(pRootOfTree.right);
    }
}
