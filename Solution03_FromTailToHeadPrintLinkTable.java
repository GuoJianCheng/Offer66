package offer66;

import java.util.ArrayList;
import java.util.Stack;

public class Solution03_FromTailToHeadPrintLinkTable {
    /**
     * 题目：从尾到头打印链表
     * 题干：输入一个链表，按链表从尾到头的顺序返回一个ArrayList
     * 解题思路：1.采用递归，先一直递归到最后一个节点，然后依次往ArrayList中存入节点值
     * 2.采用栈，先进后出的思想
     */

    /*ArrayList<Integer> al = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursive(listNode);
        return al;
    }

    public void recursive(ListNode listNode){
        if(listNode!=null){
            if(listNode.next!=null)
                recursive(listNode.next);
            al.add(listNode.val);
        }
    }*/

    //=================================================================================

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while(!stack.empty()){
            al.add(stack.pop());
        }

        return al;
    }


}
