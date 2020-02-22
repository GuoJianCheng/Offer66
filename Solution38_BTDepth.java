package offer66;

public class Solution38_BTDepth {
    /**
     * 题目：二叉树的深度
     * 题干：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
     * 形成树的一条路径，最长路径的长度为树的深度
     * 解题思路：使用递归的方法
     * 1.如果一棵树只有一个节点，那么它的深度为1
     * 2.如果一棵树只有左子树而没有右子树，那么它的深度为左子树的深度加1
     * 3.如果一棵树既有左子树又有右子树，那么该树的深度就是左、右子树深度较大的值加1
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left > right) ? (left + 1):(right+1);
    }
}
