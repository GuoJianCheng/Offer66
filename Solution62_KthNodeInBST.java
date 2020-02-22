package offer66;

public class Solution62_KthNodeInBST {
    /**
     * 题目：二叉搜索树的第k个结点
     *
     * 题干：给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     *
     * 解题思路：只需要中序遍历即可
     *
     * @param pRoot
     * @param k
     * @return
     */

    public int kth;

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0)
            return null;
        kth = k;
        return KthNodeCore(pRoot);
    }

    TreeNode KthNodeCore(TreeNode pRoot){
        TreeNode target = null;

        if(pRoot.left != null)
            target = KthNodeCore(pRoot.left);

        if(target == null){
            if(kth == 1)
                target = pRoot;
            kth--;
        }

        if(target == null &&pRoot.right != null)
            //一定要有target == null判断，一旦target不为空，即为找到了第k大结点，此时，就不需要再搜索右节点了
            target = KthNodeCore(pRoot.right);

        return target;
    }
}
