package offer66;

public class Solution53_isNumeric {
    /**
     * 题目：表示数值的字符串
     * 题干：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * 解题思路：1.正则表达式
     * 2.
     * @param str
     * @return
     */
    /*public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }*/

    public int index = 0;

    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0)
            return false;
        boolean numeric = scanInteger(str);
        if(index<str.length && str[index] == '.'){
            index++;
            //下面一行代码用||的原因：
            //1.小数可以没有整数部分，如.123 = 0.123；
            //2.小数可以没有小数点后面的部分，如233. = 233.0；
            //3.当然，小数点前面和后面都可以有数字，如233.666
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if(index<str.length && (str[index] == 'e' || str[index] == 'E')){
            index ++;
            //下面一行代码用&&的原因：
            //1.当e或E前面没有数字时，整个字符串不能表示数字，如 .e1、E1
            //2.当e或E后面没有整数时，整个字符串不能表示数字，如 12e、12e+5.4
            numeric = scanInteger(str) && numeric;
        }
        return numeric && (index==str.length);
    }

    public boolean scanInteger(char[]str){
        if(index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    public boolean scanUnsignedInteger(char[] str){
        int start = index;
        while(index<str.length && (str[index] >= '0' && str[index] <= '9'))
            index++;
        return (index>start);
    }
}
