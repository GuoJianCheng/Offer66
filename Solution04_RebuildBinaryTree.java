package offer66;

public class Solution04_RebuildBinaryTree {

    /**
     * 题目：重建二叉树
     * 题干：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * 解题思路：通过前序遍历找到根节点，第一个就是，并创建根节点然后在中序遍历中循环找到这个根节点，这样就可以确定
     * 左子树和右子树的范围，如此往复，递归调用函数，重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0||pre==null||in == null){
            return null;
        }
        return ConstructCore(pre,0, pre.length-1, in, 0, in.length-1);
    }

    public TreeNode ConstructCore(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn){
        if(startPre>endPre || startIn>endIn)//临界条件
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn;i<=endIn;i++){
            if(in[i] == pre[startPre]){
                root.left = ConstructCore(pre, startPre+1, startPre+i-startIn,in,startIn,i-1);
                root.right = ConstructCore(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}