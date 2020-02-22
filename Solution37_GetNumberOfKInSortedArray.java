package offer66;

public class Solution37_GetNumberOfKInSortedArray {
    /**
     * 题目：数字在排序数组中出现的次数
     * 题干：统计一个数字在排序数组中出现的次数。
     * 解题思路：利用二分查找寻找第一个k和最后一个k的位置，时间复杂度O(logn)
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        int first = GetFirstK(array,k,0,array.length-1);
        int last = GetLastK(array,k,0,array.length-1);
        if(first > -1 && last > -1)
            return last-first+1;
        return 0;
    }

    public int GetFirstK(int []array, int k, int start, int end){
        if(start > end)
            return -1;
        int midIndex = (start + end) >> 1;
        int midData = array[midIndex];
        if(midData == k){
            if((midIndex > 0 && array[midIndex-1]!=k) || midIndex == 0){
                return midIndex;
            }else{
                end = midIndex - 1;
            }
        }else if(midData > k){
            end = midIndex - 1;
        }else {
            start = midIndex + 1;
        }
        return GetFirstK(array, k, start, end);
    }

    public int GetLastK(int []array, int k, int start, int end){
        if(start > end)
            return -1;
        int midIndex = (start + end) >> 1;
        int midData = array[midIndex];
        if(midData == k){
            if((midIndex < array.length-1 && array[midIndex+1]!=k) || midIndex == array.length-1){
                return midIndex;
            }else{
                start = midIndex + 1;
            }
        }else if(midData < k){
            start = midIndex + 1;
        }else {
            end = midIndex - 1;
        }
        return GetLastK(array, k, start, end);
    }
}
