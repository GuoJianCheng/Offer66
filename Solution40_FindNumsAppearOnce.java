package offer66;

public class Solution40_FindNumsAppearOnce {
    /**
     * 题目：数组中只出现一次的数字
     * 题干：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 解题思路：异或运算
     * //1. 除了有两个数字只出现了一次，其他数字都出现了两次。异或运算中，任何一个数字和自己本身异或都是0，任何一个数字和0异或都是本身。
     * //2. 如果尝试把原数组分成两个子数组，且刚好每个子数组中各自包含一个只出现一次的数字。则在该前提下，每个子数组中，只有一个数字出现了一次，其他数字都出现了两次。
     * //3. 针对每个子数组，从头到尾依次异或每个数字，则最后留下来的就是只出现了一次的数字。因为出现两次的都抵消掉了。
     * //4. 怎样实现子数组的划分呢。若对原数组从头到尾的进行异或，则最后得到的结果就是两个只出现一次的数字的异或运算结果。这个结果的二进制表示中，至少有一位为1，因为这两个数不相同。该位记为从最低位开始计数的第n位。
     * //5. 则分组的标准定为从最低位开始计数的第n位是否为1。因为出现两次的同一个数字，各个位数上都是相同的，所以一定被分到同一个子数组中，且每个子数组中只包含一个出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2)
            return ;
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }

        int indexBit = FindFirstBitIs1FromRigth(resultExclusiveOR);
        for (int j = 0; j < array.length; j++) {
            if (IsBit1FromRight(array[j], indexBit)){
                num1[0] ^= array[j];
            }else{
                num2[0] ^= array[j];
            }
        }
    }

    //FindFirstBitIs1FromRigth用来在整数num的二进制表示中找到最右边是1的位
    public int FindFirstBitIs1FromRigth(int num){
        int indexBit = 0;
        while((num & 1) == 0 && indexBit < 32){
            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    //IsBit1FromRight的作用是判断在num的二进制表示中从右边数其的indexBit是否为1
    public boolean IsBit1FromRight(int num, int indexBit){
        num >>= indexBit;
        return ((num & 1) == 1);
    }
}
