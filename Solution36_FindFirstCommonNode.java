package offer66;

public class Solution36_FindFirstCommonNode {
    /**
     * 题目：两个链表的第一个公共结点
     * 题干：输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * 解题思路：这两个链表的特点像一个Y,第一个公共结点之后的结点全部重合，因为单向链表只有一个next引用
     * 1.使用两个栈,两个链表分别入栈，再弹栈，直到最后一个栈顶相同的元素
     * 2.我们可以首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。
     * 在第二次遍历的时候，在较长的链表上先走若干步，接着再同时在两个链表上遍历，找到的第一个相同的结点就是它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = GetListLength(pHead1);
        int length2 = GetListLength(pHead2);
        int dif = length1 - length2;
        ListNode pLongHead;
        ListNode pShortHead;
        if (dif > 0){
            pLongHead = pHead1;
            pShortHead = pHead2;
        }else{
            pLongHead = pHead2;
            pShortHead = pHead1;
            dif = -dif;
        }
        for (int i = 0; i < dif; i++) {
            pLongHead = pLongHead.next;
        }

        while(pLongHead != null && pShortHead != null && pLongHead.val != pShortHead.val){
            pLongHead = pLongHead.next;
            pShortHead = pShortHead.next;
        }
        if (pLongHead != null && pShortHead != null)
            return pLongHead;
        return null;
    }

    public int GetListLength(ListNode pHead){
        ListNode pNode = pHead;
        int length = 0;
        while(pNode != null){
            pNode = pNode.next;
            length++;
        }
        return length;
    }
}
