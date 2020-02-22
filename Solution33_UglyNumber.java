package offer66;

public class Solution33_UglyNumber {
    /**
     * 题目：丑数
     * 题干：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
     * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 解题思路：定义一个数组ugly[index]，并且ugly[0] = 1。
     *          维护3个引用，p2 = 0,p3 = 0,p5 = 0,初始三个引用均指向数组的第一个元素ugly[0]
     *          思路为：将数组中的p2,p3,p5指向的数组下标的元素(不能漏掉)均乘以2,3,5，
     *                  找出3个乘积的最小值，加入数组中，并且对应的px加1.
     *                  如此循环。
     *
     *
     * @param index
     * @return
     */

    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        int [] ugly = new int[index];
        ugly[0] = 1;
        int count = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int min;
        while(count < index){
            min = Min(ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5);
            ugly[count] = min;
            //这三条if防止有重复的情况
            if(ugly[p2] * 2 <= ugly[count]) p2++;
            if(ugly[p3] * 3 <= ugly[count]) p3++;
            if(ugly[p5] * 5 <= ugly[count]) p5++;
            count++;
        }
        return ugly[index-1];
    }

    public int Min(int num1, int num2, int num3){
        int min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;
        return min;
    }
}
