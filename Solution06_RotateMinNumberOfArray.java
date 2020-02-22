package offer66;

public class Solution06_RotateMinNumberOfArray {
    /**
     * 题目：旋转数组的最小数字
     * 题干：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * 解题思路：二分查找法，时间复杂度为log n 两个指针分别指向第一个和最后一个元素，中间的元素A如果大于等于第一个元素，则A位于前面的
     * 递增序列，将index1=indexMid；若A小于等于最后一个元素，则A位于后面的递增序列，将index2=indexMid。终止条件是
     * 当index2和index1相邻时终止，index2即为最小数字。
     * 特例：当旋转数组时，0个元素旋转到数组的后面，也就是说，这个旋转数组还是原来的递增数组，这样
     * 第一个元素小于最后一个元素，这个时候直接输出第一个元素。
     * 当index1和index2和中间元素都相等的时候，不能确定中间元素在前面递增部分还是后面，只能循环查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        int index1 = 0;
        int index2 = array.length-1;
        int indexMid = index1;

        while(array[index1] >= array[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            if(array[index1] == array[index2] && array[index1] == array[indexMid]){
                return MinInOrder(array, index1, index2);
            }

            if(array[indexMid] >= array[index1]){
                index1 = indexMid;
            }else if(array[indexMid] <= array[index2]){
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    public int MinInOrder(int [] array, int index1, int index2){
        int min = array[index1];
        for (int i = index1; i <= index2; i++) {
            if(min > array[i])
                min = array[i];
        }
        return min;
    }
}
