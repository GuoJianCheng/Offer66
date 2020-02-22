package offer66;

public class Solution56_DeleteDuplicationNodeInLinkedList {
    /**
     * 题目：删除链表中重复的结点
     *
     * 题干：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 解题思路：因为头结点pHead也有可能会被删除，所以再创建一个头pPreHead,并且连接上
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;
        //因为头结点pHead也有可能会被删除，所以再创建一个头pPreHead,并且连接上
        ListNode pPreHead = new ListNode(Integer.MIN_VALUE);
        pPreHead.next = pHead;
        ListNode pPre = pPreHead;
        ListNode pNode = pPreHead.next;
        while(pNode != null){
            ListNode pNext = pNode.next;
            if(pNext != null && pNext.val == pNode.val){
                //找到重复的结点，开始往后遍历到不重复的结点，将pPre和它连上，中间重复的就删除了
                int value = pNode.val;
                while(pNode != null && pNode.val == value){
                    pNode = pNode.next;
                }
                pPre.next = pNode;
            }else{//当前结点不是重复结点，往后走一步
                pPre = pNode;
                pNode = pNext;
            }
        }
        //这里就体现出了新创建的头结点的作用了
        return pPreHead.next;
    }
}
