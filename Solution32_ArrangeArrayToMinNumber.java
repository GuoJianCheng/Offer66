package offer66;

import java.util.*;

public class Solution32_ArrangeArrayToMinNumber {
    /**
     * 题目：把数组排成最小的数
     * 题干：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * 解题思路：重写Collections.sort中的Comparator参数，将排序规则改成字符串的排序规则
     */
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //两个数组合，一前一后，判断这两个组合的字符串的大小即可
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        String str = "";
        for(int j : list)
            str += j;
        return str;
    }
}
