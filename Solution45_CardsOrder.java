package offer66;

import java.util.Arrays;

public class Solution45_CardsOrder {
    /**
     * 题目：扑克牌顺子
     * 题干：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
     * A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
     * 解题思路：
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        //从小到大排序
        Arrays.sort(numbers);
        //统计0的个数
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0)
                zero++;
            else
                break;
        }
        //统计非0的间隔数
        int gap = 0;
        int small = zero;
        int big = small + 1;
        while(big<numbers.length){
            if(numbers[small] == numbers[big])//有对子，不连续
                return false;
            gap += numbers[big] - numbers[small] - 1;
            small++;
            big++;
        }
        //当间隔数小于0的个数的时候， 0可以为任意数，这样就是连续的了
        return (gap<=zero)?true:false;
    }
}
