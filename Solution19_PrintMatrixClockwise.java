package offer66;

import java.util.ArrayList;

public class Solution19_PrintMatrixClockwise {
    /**
     * 题目：顺时针打印矩阵
     * 题干：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * 解题思路：循环终止条件为columns > start * 2 && rows > start * 2
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null)
            return null;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while(columns > start * 2 && rows > start * 2){
            PrintMatrixInCircle(array,matrix,columns,rows,start);
            start++;
        }
        return array;
    }

    public void PrintMatrixInCircle(ArrayList<Integer> array,int [][] matrix,int columns, int rows, int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            array.add(matrix[start][i]);
        }
        //从上到下打印一列
        if(endY > start){
            for (int i = start+1; i <= endY; i++) {
                array.add(matrix[i][endX]);
            }
        }

        //从右到左打印一行,至少是两行两列
        if(endX > start &&endY > start){
            for (int i = endX - 1; i >= start ; i--) {
                array.add(matrix[endY][i]);
            }
        }

        //从下到上打印一列，至少有三行两列
        if(endX>start && endY > start + 1){
            for (int i = endY-1; i >= start+1 ; i--) {
                array.add(matrix[i][start]);
            }
        }
    }
}
