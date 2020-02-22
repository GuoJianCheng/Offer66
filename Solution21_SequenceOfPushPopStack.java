package offer66;

import java.util.Stack;

public class Solution21_SequenceOfPushPopStack {
    /**
     * 题目：栈的压入、弹出序列
     * 题干：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * 解题思路：
     * @param pushA
     * @param popA
     * @return
     */

    Stack<Integer> stack = new Stack<Integer>();

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null)
            return false;
        //当pushA栈顶元素不是popA要弹出的元素时，一直pushA压栈直到，pushA栈顶元素与popA要弹出的元素相同，
        //如果压栈结束也没有遇见相同的，则输出false
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < popA.length; i++) {
            while(stack.empty() || stack.peek() != popA[i]){
                if(j == pushA.length)//全部pushA压栈也也未找到其栈顶与popA要弹出的元素相同的元素
                    break;
                stack.push(pushA[j]);
                j++;
            }
            if(stack.peek() != popA[i]){//全部pushA压栈也也未找到其栈顶与popA要弹出的元素相同的元素
                flag = true;
                break;
            }
            stack.pop();
        }
        if(flag)
            return false;
        return true;

    }
}
