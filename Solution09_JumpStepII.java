package offer66;

public class Solution09_JumpStepII {
    /**
     * 题目：变态跳台阶
     * 题干：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 解题思路：数学归纳，f(n) = 2^(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target <= 0)
            return 0;
        return (int)Math.pow(2,target-1);
    }
}
