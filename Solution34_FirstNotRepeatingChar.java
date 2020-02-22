package offer66;

import java.util.HashMap;

public class Solution34_FirstNotRepeatingChar {
    /**
     * 题目：第一个只出现一次的字符
     * 题干：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     * 解题思路：哈希表实现
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        char[] cs = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = cs[i];
            if (map.containsKey(c)){
                int num = map.get(c);
                num++;
                map.put(c,num);
            }else{
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = cs[i];
            if(map.get(c) == 1)
                return i;
        }
        return -1;
    }
}
