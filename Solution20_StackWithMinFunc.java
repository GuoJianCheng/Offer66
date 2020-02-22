package offer66;

import java.util.Stack;

public class Solution20_StackWithMinFunc {
    /**
     * 题目：包含min函数的栈
     * 题干：定义栈的数据结构，请在该类型中实现一个能够得到
     * 栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 解题思路：多定义一个栈min，这个的栈顶存放当前栈stack中的最小值，当stack压栈时，该元素和min栈顶元素
     * 比较大小，小的话入栈，否则原先的栈顶元素再入栈；当stack弹栈时，min也跟着弹栈。
     */

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        if(stack.empty())
            min.push(node);
        else{
            if(min.peek() <= node)
                min.push(min.peek());
            else
                min.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if(!stack.empty()){
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
