package offer66;

public class Solution52_RegexMatch {
    /**
     * 题目：正则表达式匹配
     *
     * 题干：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     * 解题思路：
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int i, char[] pattern, int j){
        if(i == str.length && j == pattern.length)
            return true;
        if(i < str.length && j == pattern.length)
            return false;
        if(i == str.length && j == pattern.length - 2 && pattern[j+1] == '*')
            //"a"  "ab*"
            //""   ".*"
            //""   "c*"
            return true;
        else if(i == str.length && j<pattern.length)
            return false;
        if(j<pattern.length-1 && pattern[j+1] == '*'){
            if(pattern[j] == str[i] || (pattern[j]=='.' && i!=str.length)){
                        //二者移动到下一个状态
                return matchCore(str, i+1, pattern, j+2) ||
                        //pattern保持当前状态
                        matchCore(str, i+1, pattern, j)||
                        //忽略pattern的*
                        matchCore(str, i, pattern, j+2);
            }else{
                //忽略pattern的*
                return matchCore(str, i, pattern, j+2);
            }
        }
        if (str[i] == pattern[j] || (pattern[j]=='.' && i!=str.length))
            return matchCore(str, i+1, pattern, j+1);
        return false;
    }

}
