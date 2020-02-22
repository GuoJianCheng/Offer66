package offer66;

public class Solution55_EntryNodeOfLoop {
    /**
     * 题目：链表中环的入口结点
     *
     * 题干：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     * 解题思路：1.定义两个指针，一个指针pSlow一次走一步，另一个指针pFast一次走两步，如果pFast追上了pSlow，
     *          证明链表中存在环，如果pFast走到了null还没有追上pSlow,证明不存在环。
     *          2.如果有环，pFast和pSlow相遇的结点pNode定然在环中，从pNode开始沿着环转一圈，得到环的结点数n
     *          3.定义两个指针，p1，p2；p2先走n步，然后p1和p2同步走，当p1==p2时，即为链表中环的入口结点
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = MeetingNode(pHead);
        if(meetingNode == null)
            return null;
        int nodesInLoop = 1;
        ListNode pNode = meetingNode.next;
        while(pNode != meetingNode){
            pNode = pNode.next;
            nodesInLoop++;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            p2 = p2.next;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode MeetingNode(ListNode pHead){
        if(pHead == null)
            return null;
        if(pHead.next == null)
            return null;
        ListNode pSlow = pHead;
        ListNode pFast = pHead.next.next;
        while(pFast != null && pFast.next != null){
            if(pFast == pSlow)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return null;
    }
}
