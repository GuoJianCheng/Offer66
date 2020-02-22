package offer66;

public class Solution17_SubStructureOfTree {
    /**
     * 题目：树的子结构
     * 题干：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * 解题思路：递归遍历
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        boolean result = false;
        if(root1.val == root2.val)
            result = DoesTree1HaveTree2(root1, root2);
        if(!result)
            result = HasSubtree(root1.left, root2);
        if(!result)
            result = HasSubtree(root1.right, root2);
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
