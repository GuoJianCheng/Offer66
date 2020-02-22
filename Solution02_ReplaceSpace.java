package offer66;

import java.util.UUID;

public class Solution02_ReplaceSpace {


    /**
     * 题目：替换空格
     *
     * 题干：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     *例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * 解题思路：
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        /*if(str==null)
            return null;
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();*/

        //本地替换
        if(str == null)
            return null;
        int spaceNum = 0;
        int oldLength = str.length();
        int newLength = 0;
        for (int i = 0; i < oldLength; i++) {
            if(str.charAt(i) == ' ')
                spaceNum++;
        }
        newLength = oldLength + spaceNum * 2;
        str.setLength(newLength);
        int p_old = oldLength - 1;
        int p_new = newLength - 1;
        while(p_old>=0&&p_new>=0){
            char c = str.charAt(p_old);
            if(c == ' '){
                str.setCharAt(p_new--,'0');
                str.setCharAt(p_new--,'2');
                str.setCharAt(p_new--,'%');
            }else{
                str.setCharAt(p_new--,c);
            }
            p_old--;
        }
        return str.toString();
    }
}
