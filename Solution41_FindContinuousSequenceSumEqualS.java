package offer66;

import java.util.ArrayList;

public class Solution41_FindContinuousSequenceSumEqualS {
    /**
     * 题目：和为S的连续正数序列
     * 题干：输入一个正数s,打印出所有和为s的连续正数序列（至少含有两个数）。
     * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15；所以打印出三个连续序列1~5,4~6,7~8
     * 解题思路：我们也考虑用两个树small和big分别表示序列的最小值和最大值。首先把small初始化为1，
     * big初始化为2.如果从small到big的序列的和大于s，我们可以从序列中去掉较小的值，也就是增大small的值。
     * 如果从small到big的序列的和小于s，我们可以增大big,让这个序列包含更多的数字。
     * 因为这个序列至少要有两个数字，我们一直增加small 到（1+s)/2为止。
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum<3)
            return result;
        int small = 1;
        int big = 2;
        int mid = (sum+1)/2;
        int curSum = small + big;
        while(small < mid){
            if(curSum == sum){
                AddContinueSequence(result, small, big);
                curSum -= small;
                small++;
            }else if(curSum < sum){
                big++;
                curSum += big;
            }else{
                curSum -= small;
                small++;
            }
        }
        return result;
    }

    public void AddContinueSequence(ArrayList<ArrayList<Integer>> result, int small, int big){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        result.add(list);
    }
}
