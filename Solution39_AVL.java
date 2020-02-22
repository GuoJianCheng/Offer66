package offer66;

/**
 * 题目：平衡二叉树
 * 题干：输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * 解题思路：后序遍历
 * 1.平衡二叉树：左右子树的深度不超过1
 * 2.此题需要定义定义一个类，这样depth才不会因为作用域和作用范围的问题传不过去啊。
 * 3.左右子树的差都要小于1。
 */
public class Solution39_AVL {

    class Depth{
        int val = 0;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        Depth depth = new Depth();
        return IsBalanced(root, depth);
    }

    public boolean IsBalanced(TreeNode root, Depth depth){
        if(root == null){
            depth.val = 0;
            return true;
        }
        Depth left = new Depth();
        Depth right = new Depth();
        if(IsBalanced(root.left, left) && IsBalanced(root.right, right)){
            int dif = left.val - right.val;
            if(dif>=-1 && dif<=1){
                depth.val = (left.val > right.val) ? (left.val + 1) : (right.val + 1);
                return true;
            }
        }
        return false;
    }


}
