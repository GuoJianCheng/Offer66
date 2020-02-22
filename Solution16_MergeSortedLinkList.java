package offer66;

public class Solution16_MergeSortedLinkList {
    /**
     * 题目：合并两个排序的链表
     * 题干：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * 解题思路：递归解决。当比较list1的第一个结点和list2的第一个结点的大小之后，找出二者的小的那个作为merge，
     * 接下来的过程是，merge结点指向剩下的两个链表，而剩下的两个链表以相同的方式比较大小......
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 != null && list2 == null){
            return list1;
        }else if(list1 == null && list2 != null){
            return list2;
        }
        ListNode merge = null;
        if(list1.val <= list2.val){
            merge = list1;
            merge.next = Merge(list1.next, list2);
        }else{
            merge = list2;
            merge.next = Merge(list1, list2.next);
        }
        return merge;
    }
}
