package offer66;

import java.util.HashMap;
import java.util.Map;

public class Solution28_MoreThanHalfNumInArray {
    /**
     * 题目：数组中出现次数超过一半的数字
     * 题干：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 解题思路：基于数组特点找出时间复杂度为 O(n) 的算法
     * 1、数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多。
     * 因此，我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字；另一个是次数。
     * ２、当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加１；
     * 如果下一个数字和我们之前保存的数字不同，则次数减１；如果次数为０，那么我们需要保存下一个数字，并把次数设为1
     * ３、由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
     * 那么要找的数字肯定是最后一次把次数设为１时对应的而数字
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length == 0)
            return 0;
        int num = array[0];
        int count = 0;
        //{1,2,3,2,4,2,5,2,3}
        for (int i = 0; i < array.length; i++) {
            if(array[i] == num){
                count++;
            }else{
                count--;
            }
            if(count == 0 && i <array.length-1){
                num = array[i+1];
            }
        }
        //验证
        //{1,2,3,2,4,2,5,2,3}这种情况到最后会把元素3的次数设置为1，此时要是输出3则错误，因此需要验证
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == num)
                count++;
        }
        return (count*2>array.length)?num:0;
    }
}
