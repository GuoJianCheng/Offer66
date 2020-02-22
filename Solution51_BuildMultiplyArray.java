package offer66;

public class Solution51_BuildMultiplyArray {
    /**
     * 题目：构建乘积数组
     *
     * 题干:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     *
     * 解题思路：
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length == 0)
            return B;
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int tmp = 1;
        for (int j = length - 1; j > 0 ; j--) {
            tmp *= A[j];
            B[j-1] *= tmp;
        }
        return B;
    }
}
