package offer66;

import java.util.ArrayList;

public class Solution46_LastRemainingInCircle {
    /**
     * 题目：孩子们的游戏(圆圈中最后剩下的数)
     * 题干：0，1，...，n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个
     * 圆圈里剩下的最后一个数字。
     * 解题思路：1.用ArrayList模拟圆圈，remove(index)可以从列表中删除下标为index的数字
     * 2.
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0)
            return -1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while(list.size() > 1){
            index = (index + m-1) % list.size();
            list.remove(index);
        }
        return list.get(0);

    }
}
