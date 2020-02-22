package offer66;

public class Solution47_Sum1_n {
    /**
     * 题目：求1+2+3+...+n
     * 题干：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 解题思路：利用递归
     * 此外还有个技巧就是，如何不适用if语句终止递归，那就是
     * 在最后一次递归中ans=0，利用 && 的短路特性，当前操作数为0就不计算后操作数了，因此递归结束
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int ans = n;
        boolean flag = (ans != 0) && ((ans += Sum_Solution(n - 1)) != 0);
        return ans;
    }
}
