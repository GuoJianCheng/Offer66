package offer66;

import java.util.Stack;

public class Solution05_QueueWithStack {


    /**
     * 题目：用两个栈实现队列
     * 题干：用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。
     * 解题思路：stack1正常用于push，关键是在于stack2和pop操作，当stack2为空时，将stack1中的数据依次弹出
     * 并且压入stack2中，使得stack1为空，这样从stack2中进行pop操作，就完成了队列的先进先出操作
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
