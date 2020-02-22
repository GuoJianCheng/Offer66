package offer66;

public class Solution50_DuplicateNumInArray {
    /**
     * 题目：数组中重复的数字
     *
     * 题干：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
     * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     *
     * 解题思路：从头到尾依次扫描这个数组中的每个数字，当扫描到下标为i的数字时，
     * 首先比较这个数字（用m表示）是否等于i，如果是，则接着扫描下一个数字；
     * 如果不是，则再拿它和第m个数字进行比较。如果它和第m个数字相等说明它就是第一个重复的数字，
     * 如果不相等则把第i个数字和第m个数字交换，把m放回原来的位置。
     *
     * 注意：duplicate1尽管有两重循环，但每个数字最多只要交换两次就能找到属于它自己的位置，
     * 总的时间复杂度为O(n)，空间复杂度为O(1)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0)
            return false;
        //1.单个的boolean 类型变量在编译的时候是使用的int 类型。 boolean a=true;这个a在JVM中占4个字节即:32位。
        // 2.boolean 类型的数组时,在编译的时候是作为byte array来编译的，所以boolean 数组里面的每一个元件占一个字节
        boolean []flag = new boolean[length];
        for (int i = 0; i < length; i++) {
            if(numbers[i] < 0 || numbers[i] >= length)
                return false;
            if(flag[numbers[i]] == true){
                duplication[0] = numbers[i];
                return true;
            }
            flag[numbers[i]] = true;
        }
        return false;
    }

    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            if(numbers[i] < 0 || numbers[i] >= length)
                return false;
        }
        for (int i = 0; i < length; i++) {
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return false;
    }
}
