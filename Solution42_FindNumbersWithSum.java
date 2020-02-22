package offer66;

import java.util.ArrayList;

public class Solution42_FindNumbersWithSum {
    /**
     * 题目：和为S的两个数字
     * 题干：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 解题思路：两个引用，第一个引用p1指向数组的第一个数字，第二个引用p2指向数组的最后一个数字
     * 当两个引用指向的数字之和等于sum时，满足条件
     * 当两个引用指向的数字之和大于sum时，p2--
     * 当两个引用指向的数字之和小于sum时，p1++
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length == 0)
            return list;
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 < p2){
            if(array[p1] + array[p2] == sum){
                if(list.isEmpty()){
                    list.add(array[p1]);
                    list.add(array[p2]);
                    p1++;
                    p2--;
                }else{
                    int multiply1 = list.get(0) * list.get(1);
                    int multiply2 = array[p1] * array[p2];
                    if(multiply1 > multiply2){
                        list.set(0,array[p1]);
                        list.set(1,array[p2]);
                    }
                    p1++;
                    p2--;
                }
            }else if(array[p1] + array[p2] > sum){
                p2--;
            }else{
                p1++;
            }
        }
        return list;
    }
}

