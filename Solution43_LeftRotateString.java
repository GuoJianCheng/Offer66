package offer66;

public class Solution43_LeftRotateString {
    /**
     * 题目：左旋转字符串
     * 题干：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * 解题思路：reverse函数很重要，先翻转第一部分，再翻转第二部分，最后翻转整个句子
     * 注意：当字符串的场地小于等于要左旋的位数时，不需要旋转了
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() < 2 || n < 0 || str.length() <= n){
            return str;
        }

        char[]cs = str.toCharArray();
        reverse(cs, 0, n-1);
        reverse(cs, n, cs.length-1);
        reverse(cs, 0, cs.length-1);

        return String.valueOf(cs);
    }

    public void reverse(char[]cs, int start, int end){
        char temp = ' ';
        while(start < end){
            temp = cs[start];
            cs[start++] = cs[end];
            cs[end--] = temp;
        }
    }
}
