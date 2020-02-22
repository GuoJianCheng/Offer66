package offer66;

import java.util.HashMap;
import java.util.Map;

public class Solution54_FirstNotRepeatCharInStream {
    /**
     * 题目：字符流中第一个不重复的字符
     *
     * 题干：请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     *
     * 解题思路：
     * @param ch
     */

    public int [] occurrence = new int [256];
    int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(occurrence[ch] == 0)
            occurrence[ch] = index;
        else if(occurrence[ch] > 0)//重复
            occurrence[ch] = -1;
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if(occurrence[i] > 0 && occurrence[i] < minIndex){
                ch = (char)i;
                minIndex = occurrence[i];
            }
        }
        return ch;
    }
}
