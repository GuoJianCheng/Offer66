package offer66;

public class Solution18_BTMirror {
    /**
     * 题目：二叉树的镜像
     * 题干：操作给定的二叉树，将其变换为源二叉树的镜像。
     * 解题思路：递归，简单
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null)
            return ;
        if(root.left == null && root.right == null)
            return ;
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
