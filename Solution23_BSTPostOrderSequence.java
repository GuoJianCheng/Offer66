package offer66;

public class Solution23_BSTPostOrderSequence {
    /**
     * 题目：二叉搜索树的后序遍历序列
     * 题干：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 解题思路：序列的最后一个元素为根节点，前面的部分分为左子树和右子树，左子树的序列全部小于根节点，
     * 右子树的序列全部大于根节点，在右子树的序列中一旦出现小于根节点的值，则该数据不能构成二叉搜索树
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length == 0)//一定是这两个条件！1.空  2.sequence=[]，这个不为空，但是length=0
            return false;
        return VerifySquenceOfBSTCore(sequence, 0,sequence.length - 1);

    }

    public boolean VerifySquenceOfBSTCore(int [] sequence, int start, int end){
        if(start >= end)
            return true;
        int root = sequence[end];
        //在二叉搜索树中左子树结点的值小于根节点的值
        int i = start;
        for(;i< end;i++){
            if(sequence[i] > root)
                break;
        }
        //在二叉搜索树中右子树结点的值大于根节点的值
        for(int j = i;j<end;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = VerifySquenceOfBSTCore(sequence, start, i-1);//这里是i-1，因为i对应的值大于root，所以取前面一个值
        boolean right = VerifySquenceOfBSTCore(sequence, i+1, end-1);
        return (left && right);
    }
}
