package offer66;

public class Solution11_NumOf1InBinary {
    /**
     * 题目：二进制中1的个数
     * 题干：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 解题思路：1.会引起死循环的思路：把输入的数与1做按位与运算，当把输入的数n一直右移的时候，正数还好，能得出正确结果，但是负数就不行，
     *          因为负数有符号位，右移之后，高位是用1补位
     *          2.常规解法：n不动，将1一直左移，当整型的1移到最高位时是1000 0000 0000 0000 0000 0000 0000 0000(这代表一个负数)
     *          然后再右移一位，就变成0了。这需要循环32次
     *          3.整数中有几个1就只需要循环几次：把整数减1，再和原来整数做与运算，就会把整数最右边的1变为0
     *
     * @param n
     * @return
     */
    /*public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }*/

    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & n-1 ;
        }
        return count;
    }
}
