package offer66;

import java.util.*;

public class Solution29_GetLeastKNumbers {
    /**
     * 题目：最小的K个数
     * 题干：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * 解题思路：1.利用Partition函数解决，达到这样的效果，在data[k]的左边是比它小的，右边比它大的。简单划分，但是并不排序
     *            需要寻找k。时间复杂度O(n)，会修改输入的数组。
     *          2.我们可以创建一个容量为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。
     *          如果容器中已有的数字少于k个，则直接把这次读入的整数放入容器之中；
     *          如果容器中已有k个数字了（即容器满了），我们就不能再插入数字了，只能去替换容器中已有的数字。
     *          替换的规则是，我们拿待插入的数字和容器中k个数字中的最大值进行比较，
     *          如果大于容器中的最大值，则抛弃这个整数，否则用这个整数去替换这个数字。
     *
     *          故，容器满了之后，我们需要做3件事：一是在k个整数中找到最大数；
     *          二是有可能在这个容器中删除这个最大数；三是有可能会在这个容器中插入一个新数字。
     *          用二叉树实现这个容器，我们能在O(logk)时间内实现这三步操作。因此对于n个数字而言，
     *          总的时间效率就是O（nlogk）。
     *
     *          容器的实现用数据结构中的最大堆，因为其根结点的值永远是最大的结点值。
     *          我们用红黑树来实现我们的最大堆容器。而TreeSet类实现了红黑树的功能，
     *          它的底层是通过TreeMap实现的，TreeSet中的数据会按照插入数据自动升序排序。
     *          我们只需要将数据放入TreeSet中，其就会为我们实现排序。
     * 总结：借助于一个容器来存储这k个最小的数，有两个优点：（1）没有修改输入的数据；
     * （2）这个算法适合海量数据的输入。算法的题目可以改成从海量数据中找出k个最小的数。
     * 第一个利用快速排序的思想的时间复杂度为O（n）,后一个借助于一个容器的思想的时间复杂度为O（nlogk）。

     * @param input
     * @param k
     * @return
     */
    //方法1：
/*    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length==0 || k<=0 || k>input.length)
            return list;
        int start = 0;
        int end = input.length-1;
        int index = Partition(input, start, end);
        while(index!=k-1){
            if (index > k-1){
                end = index-1;
                index = Partition(input, start, end);
            }else{
                start = index+1;
                index = Partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public int Partition(int [] data, int start, int end){
        int i = start, j = end;
        int tmp;
        if(start<end){//区间内至少存在两个元素，否则只有1个或0个就不排序了
            tmp = data[start];
            while(i != j){
                while(j>i && data[j]>=tmp)//从右向左扫描，找到第1个小于tmp的data[j]
                    j--;

                data[i] = data[j];

                while(i<j&&data[i]<=tmp)//从左向右扫描，找到第1个大于tmp的data[i]
                    i++;
                data[j] = data[i];
            }
            data[i] = tmp;
            //至此一趟快速排序已经结束在data[i]之前的元素小于data[i]，之后的元素大于data[i]
        }
        return i;
    }*/

/*    //红黑树
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length==0 || k<=0 || k>input.length)
            return list;
        int length = input.length;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < length; i++) {
            if(treeSet.size() < k){
                treeSet.add(input[i]);
            }else if (input[i]<treeSet.last()){
                *//*Java.util.TreeSet.last()方法用于返回TreeSet的最后一个元素。
                这里的最后一个元素被引用到集合中最高的元素。如果元素是整数类型，
                则返回最大的整数。如果元素是字符串类型，则按字母顺序检查元素，
                并返回以字典顺序的最后一个字母开头的字符串，而不管长度如何。*//*
                treeSet.remove(treeSet.last());
                treeSet.add(input[i]);
            }
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }*/

    //最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return list;
        int length = input.length;
        /*
        PriorityQueue的逻辑结构是一棵完全二叉树，存储结构其实是一个数组。逻辑结构层次遍历的结果刚好是一个数组。
        add(E e) 和 offer(E e) 方法
        poll() 和 remove() 方法
        PriorityQueue默认是一个小顶堆，然而可以通过传入自定义的Comparator函数来实现大顶堆
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < length; i++) {
            if(maxHeap.size() < k){
                maxHeap.offer(input[i]);
            }else if (input[i]<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        for (Integer i:maxHeap) {
            list.add(i);
        }
        return list;
    }
}
