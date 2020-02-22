package offer66;

public class Solution14_ReciprocalKNodeInLinkList {
    /**
     * 题目：链表中倒数第k个结点
     * 题干：输入一个链表，输出该链表中倒数第k个结点。
     * 解题思路：一开始p1和p2同指向头结点，然后p1先走k-1步，然后p2和p1一同往前走
     * 注意：这里的头结点head就是直接指向含数值的那个结点，比如1->2->3->4->5,head就是指向1的结点
     * 还需要注意鲁棒性，head是否为空，k是否为0等
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null || k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int flag = 1;
        while(p1 != null && flag < k){
            p1 = p1.next;
            flag++;
        }
        if(p1 == null)
            return null;
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
