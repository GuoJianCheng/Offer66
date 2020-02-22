package offer66;

import java.util.ArrayList;
import java.util.List;

public class Solution13_OddBeforeEven {
    /**
     * 题目：调整数组顺序使奇数位于偶数前面
     * 题干：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     *      所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 解题思路：只申请一个额外的数组，将原来的数组从左往右扫，遇到奇数就存到新数组的左边，
     * 同时将原来的数组从右往左扫，遇到偶数就存到新数组的右边，这样就可以保证左边是奇数，
     * 右边是偶数，且奇数之间、偶数之间相对位置不变，再合并到原数组就ok了
     */

    public void reOrderArray(int [] array) {
        int len = array.length;
        int [] arr = new int [len];
        int start = 0;
        int end = len - 1;

        for(int i = 0;i<array.length;i++){
            if((array[i] & 1) == 1)//奇数
                arr[start++] = array[i];
            if((array[len - 1 - i] & 1) == 0)//偶数
                arr[end--] = array[len - 1 - i];
        }
        for(int i = 0;i<array.length;i++){
            array[i] = arr[i];
        }
    }

    public void reOrderArray1(int [] array) {
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0;i<array.length;i++){
            if((array[i] & 1) == 1)//奇数
                arr.add(array[i]);
        }
        for(int i = 0;i<array.length;i++){
            if((array[i] & 1) == 0)//偶数
                arr.add(array[i]);
        }
        for(int i = 0;i<array.length;i++){
            array[i] = arr.get(i);
        }
    }
}
