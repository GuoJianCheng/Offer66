package offer66;

import java.util.Collections;
import java.util.ArrayList;

public class Solution27_PermutationOfString {
    /**
     * 题目：字符串的排列
     * 题干：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 解题思路：见Solution27.png
     * 第一步求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有的字符交换
     * 第二步，固定第一个字符，求后面所有字符的排列，这时后面所有字符的排列仍然可以分成两个部分，递归解决
     * 注意：Collections.sort(list);默认是正序排序，就题中字典序
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return list;
        PermutationCore(str.toCharArray(),0,list);
        Collections.sort(list);//排序
        return list;

    }

    public void PermutationCore(char[] cs, int i, ArrayList<String>list){
        if(i == cs.length-1){//递归出口
            String str = String.valueOf(cs);
            if(!list.contains(str))//保证无重复
                list.add(str);
        }else{
            for (int j = i; j < cs.length; j++) {//将cs[i]与后面的所有字符cs[j]依次交换
                swap(cs,i,j);
                PermutationCore(cs, i+1,list);
                swap(cs,i,j);//再交换回来
            }
        }
    }

    public void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }


}
