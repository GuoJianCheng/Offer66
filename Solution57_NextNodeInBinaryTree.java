package offer66;


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution57_NextNodeInBinaryTree {
    /**
     *题目：二叉树中下一个结点
     * 题干：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 解题思路：如果该结点pNode有右子树，那么该结点的下一个结点就是右子树的最左下结点
     *          如果该结点pNode没有右子树，那么当结点pNode是其父结点的左子结点的话，该父节点就是下一个结点
     *          如果该结点pNode没有右子树并且结点pNode不是其父结点的左子结点的话，情况复杂，需要向上查找：
     *              一直向上遍历，直到能够找到一个结点A满足A是它父节点的左子结点时，结束，该父节点就是下一个结点，
     *              否则没有下一个结点，返回null
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return null;
        TreeLinkNode pRight = pNode.right;
        TreeLinkNode pNext = null;

        if(pRight != null){
            while(pRight.left!=null){
                pRight = pRight.left;
            }
            pNext = pRight;
        }else if(pNode.next!=null){
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pFather = pCurrent.next;
            if(pFather.left == pNode){
                pNext = pFather;
            }else{
                while(pFather!=null && pCurrent != pFather.left){
                    pCurrent = pFather;
                    pFather = pFather.next;
                }
                pNext = pFather;
            }
        }
        return pNext;
    }
}
