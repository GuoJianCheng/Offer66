package offer66;

public class Solution01_FindFrom2DArray {

    /**
     * 题目：二维数组中的查找
     *
     * 题干：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     *
     *解题思路：从二维数组的右上角开始比较，右上角的数字大于target时，剔除当前这一列，小于的话剔除当前这一行
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        /*for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;*/

        //[i,j]是右上角的坐标
        int i = 0;
        int j = array[0].length - 1;
        while(i<array.length&&j>=0){
            if(array[i][j]==target){
                return true;
            }else if(array[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
