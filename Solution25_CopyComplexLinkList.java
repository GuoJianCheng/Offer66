package offer66;

public class Solution25_CopyComplexLinkList {
    /**
     * 题目：复杂链表的复制
     * 题干：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     *（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * 解题思路：第一种方法：复制原始链表上的每个节点，并用next连接起来；然后设置每个节点的random引用。时间复杂度O(n^2)
     *          第二种方法：复制原始链表上的每个节点，并用next连接起来，这个过程中，利用哈希表，将<N,N'>,<S,S'>对应起来，
     *                     这样就可以将N'与S'的random连起来了。时间复杂度：O(n)，空间复杂度O(n)，空间换时间
     *          第三种方法：第一步，复制原始链表上的每个节点，并用next连接起来，这一次，把N’连接在N的后面
     *                     第二步，设置复制出来的结点的random引用
     *                     第三步，拆分原始链表和复制链表
     *                     时间复杂度：O(n)
     * 注意：第三步的循环条件若是pClonedNode->next != NULL，要加这条语句pNode->next = NULL; ，否则导致原始链表的结尾还连着别的节点(E->E`)
     *         //将原始链表和复制链表拆开的时候，一定要注意结尾置空！！！！！！！一定要注意结尾置空！！！！！！！一定要注意结尾置空！！！！！！！
     *         //这里耽误了我好几个小时，啊啊啊啊啊啊啊啊啊啊啊
     */
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    //第一步，复制原始链表上的每个节点，并用next连接起来，这一次，把N’连接在N的后面
    public void CloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    //第二步，设置复制出来的结点的random引用
    public void ConnectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloned;
        while(pNode!=null){
            pCloned = pNode.next;
            if(pNode.random != null)
                pCloned.random = pNode.random.next;
            pNode = pCloned.next;
        }
    }

    //第三步，拆分原始链表和复制链表
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloned;
        RandomListNode pClonedHead = pNode.next;

        while(pNode != null){
            pCloned = pNode.next;
            pNode.next = pCloned.next;
            pNode = pNode.next;//这里到最后会变成null,要小心最后的结点，原始链表和复制链表最后的结点都应该指向null
            if(pNode !=null)
                pCloned.next = pNode.next;
        }
        return pClonedHead;
    }
}
