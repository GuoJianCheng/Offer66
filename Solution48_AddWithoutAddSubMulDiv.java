package offer66;

public class Solution48_AddWithoutAddSubMulDiv {
    /**
     * 题目：不用加减乘除做加法
     * 题干：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 解题思路：
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum;
        int carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return num1;
    }
}
