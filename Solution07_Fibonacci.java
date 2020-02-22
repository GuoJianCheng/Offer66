package offer66;

public class Solution07_Fibonacci {
    /**
     * 题目：斐波那契数列
     * 题干：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * 解题思路：不用递归，递归导致变慢，有大量重复计算
     * 用从下往上计算，如下
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n < 0)
            return -1;
        if(n == 0 || n == 1)
            return n;
        int a = 0;
        int b = 1;
        int tmp;
        for(int i = 2;i <= n;i++){
            tmp = a;
            a = b;
            b = tmp + b;
        }
        return b;
    }
}
