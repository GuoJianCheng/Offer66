package offer66;

public class Solution10_RectangleCover {
    /**
     * 题目：矩形覆盖
     * 题干：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 解题思路：斐波那契数列：f(n) = f(n-1)+f(n-2);
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target < 0)
            return 0;
        if(target == 0 || target == 1 || target == 2)
            return target;
        int a = 1;
        int b = 2;
        int tmp;
        for(int i = 3;i <= target;i++){
            tmp = a;
            a = b;
            b = tmp + b;
        }
        return b;
    }
}
