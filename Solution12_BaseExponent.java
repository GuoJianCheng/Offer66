package offer66;

public class Solution12_BaseExponent {
    /**
     * 题目：数值的整数次方
     * 题干：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     * 解题思路：1.需要注意要全面考虑情况，底数为0时，指数的正负零
     *          2.需要注意浮点数在做相等的比较时，需要二者相减小于一个很小的数时才相等
     *          3.做指数运算时，可以优化，如下所示的PowerWithExponent函数,快速乘方的方法
     *
     * @param base
     * @param exponent
     * @return
     */

    boolean invalidInput = false;

    public double Power(double base, int exponent) {
        //底数为0，指数为负，相当于除数为0，无意义
        //0的0次方也无意义
        if(equal(base, 0.0)){
            if(exponent <= 0){
                invalidInput = true;
                return 0.0;
            }else{//指数大于0
                return 0.0;
            }
        }
        int absExponent = exponent < 0 ? (-exponent) : exponent;
        double result = PowerWithExponent(base, absExponent);
        return exponent < 0 ? (1/result) : result;
    }

    public double PowerWithExponent(double base, int exponent){
        if(exponent == 0)
            return 1.0;
        if(exponent == 1)
            return base;
        double result = PowerWithExponent(base, exponent>>1);
        result *= result;
        if((exponent & 1) == 1)
            //指数为奇数
            result = result * base;
        return result;
    }

    public boolean equal(double num1, double num2){
        if(num1 - num2 < 0.000001 && num1 - num2 > -0.000001)
            return true;
        return false;
    }
}


