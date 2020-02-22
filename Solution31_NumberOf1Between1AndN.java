package offer66;

public class Solution31_NumberOf1Between1AndN {
    /**
     * 题目：整数中1出现的次数（从1到n整数中1出现的次数）
     * 题干：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
     * （从1 到 n 中1出现的次数）。
     * 解题思路：为了找到规律，我们不妨用一个稍微大一点的数字比如21345作为例子来分析。
     * 我们把从1到21345的所有数字分为两段，一段是从1到1345，另一段是从1346到21345.
     * 划分的原因是便于利用递归的思路，因为21345去掉最高位就是1345.我们先看1346到21345中1出现的次数。
     * 1的出现分为两种情况：1出现在最高位和1出现在其他位。1346到21345，1出现在10000-19999这10000个数字
     * 的最高位中，一共出现了10000个，即10^最高位。我们可以发现一般情况：如果是1346到11345，1出现
     * 在10000-11345的最高位中，一共出现2346次，也就是除去最高数字之后剩下的数字+1，当万位大于1时，
     * 1出现在最高位的次数是10^最高位。
     *
     *     接下来分析1出现在除最高位之外的其他四位数中的情况。1346-21345这20000个数字中后4位出现的次数，
     * 分成两段，1346-11345和11346-21345，每一段剩下的4位数字中，选择其中一位是1，其余三位可以在0-9这
     * 10个数字中任意选择，根据排列组合原则，总共出现次数2*4*10^3=8000次。我们可以发现一般情况：如果是
     * 1346-n1345那么，可以划分为n段，即1出现在除最高位之外的其他四位数的次数是n*4*1000;
     *
     * 总结：分情况：1.最高位，当大于1时，则是10^(length-1)个1
     *                      当等于1时，则1的个数是除了最高位的其余位组合起来的大小+1
     *             2.其余位，最高位若为n，则是n*(length-1)*10^(length-2)个1
     *             3.除去最高位，其余位递归计算1的个数
     *      1的总个数为3种情况之和。
     *      时间复杂度为O(logn)
     *      数字n的位数为O(logn)位
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        String str = n+"";

        return NumberOf1(str);
    }

    public int NumberOf1(String str){
        char [] strN = str.toCharArray();
        int length = strN.length;
        int first = strN[0]-'0';

        if(length == 1 && first == 0)
            return 0;
        if(length == 1 && first > 0)
            return 1;

        int numFirstDigit = 0;//第一位为1的数字个数
        if(first>1)
            numFirstDigit = (int)(Math.pow(10,length-1));
        else if(first == 1)
            //这里不能直接else，必须是else if(条件)，要不然会是first<=1全部情况，反例是10000
            //当第一次递归时，字符串为0000，first = 0，就会把numFirstDigit设置为1，发生错误
            numFirstDigit = Integer.parseInt(str.substring(1)) + 1;

        //除了第一位的其余位中包含1的个数
        int numOtherDigits = first * (length - 1) *(int)Math.pow(10, length - 2);

        //除去最高位，其余位递归计算1的个数
        int numRecursive = NumberOf1(str.substring(1));

        return numFirstDigit + numOtherDigits + numRecursive;

    }
}
