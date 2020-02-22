package offer66;

import java.util.ArrayList;

public class Solution24_FindSumPathInBT {
    /**
     * 题目：二叉树中和为某一值的路径
     * 题干：输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     * 解题思路：递归解决
     * @param root
     * @param target
     * @return
     */
    //一定需要注意初始化他们，要不然会导致java.lang.NullPointerException
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = FindPathWithOutOrder(root, target);
        order(result);
        return result;
    }

    public ArrayList<ArrayList<Integer>> FindPathWithOutOrder(TreeNode root, int target) {
        if(root == null)
            return result;
        path.add(root.val);
//        System.out.println(path);
        if(root.left == null && root.right == null && (target-root.val==0)){
            /*result.add(path);这里不能直接添加path，因为我们这是将path的地址给add进去了，
            并没有将真正的列表add进热resultlist，这样导致的结果就是 当你的path中的值改变后，
            result中也随之改变，不出意外的话，你最后的path变为空了，所以最后输出全空，故还需要实例化一下path*/
            result.add(new ArrayList<Integer>(path));
        }
        if(root.left != null)
            FindPath(root.left, target - root.val);
        if(root.right != null)
            FindPath(root.right, target - root.val);
        path.remove(path.size() - 1);//返回父节点时还需要将当前的这个节点从路径上删除
        return result;
    }

    public void order(ArrayList<ArrayList<Integer>> result){
        for (int i = 0; i < result.size()-1; i++) {
            for (int j = 0; j < result.size()-i-1; j++) {
                if(result.get(j).size()<result.get(j+1).size()){
                    //根据长度，交换两个ArrayList
                    ArrayList<Integer> tmp = result.get(j);
                    result.set(j,result.get(j+1));
                    result.set(j+1,tmp);
                }
            }
        }
    }
}
