package offer66;

public class Solution49_StrToInt {
    /**
     * 题目：把字符串转换成整数
     * 题干：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * 解题思路：注意
     * 边界条件：
     * 数据上下 溢出
     * 空字符串
     * 只有正负号
     * 有无正负号
     * 错误标志输出
     * @param str
     * @return
     */
    public boolean g_InvalidInput = false;
    public int StrToInt(String str) {
        if(str == null || str.length() == 0 || str.trim().equals("")||str.equals("-")||str.equals("+")){
            g_InvalidInput = true;
            return 0;
        }
        char[]cs = str.toCharArray();
        int minus = 0;
        long sum = 0;//先用long来存储，以防止越界
        if(cs[0] == '-') minus = 1;
        for (int i = minus; i < cs.length; i++) {
            if(cs[i] == '+' && i == 0)//判断第一个字符是否为+，必须要有i==0的条件，否则字符串中含有+时，也会跳过，不判错，这样不行
                continue;
            if(cs[i] < 48 || cs[i] > 57){
                g_InvalidInput = true;
                return 0;
            }
            sum = sum * 10 + (cs[i] - '0');
            if ((minus==0 && sum > 0x7FFFFFFF) || (minus == 1 && (-sum) < 0x80000000)){
                //判断是否越界，(-sum) < 0x80000000) 这里的它一定是（-sum）要取负数
                g_InvalidInput = true;
                return 0;
            }
        }
        return (int)((minus == 0) ? sum : -sum);
    }


}
