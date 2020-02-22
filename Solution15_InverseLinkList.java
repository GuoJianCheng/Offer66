package offer66;

public class Solution15_InverseLinkList {
    /**
     * 题目：反转链表
     * 题干：输入一个链表，反转链表后，输出新链表的表头。
     * 解题思路：设置三个指针，前两个指针用于反转链表，后一个指针用于保存断裂链表之后的结点。
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        //设置三个指针
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head.next;

        while(p3!=null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
}
