package offer66;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution63_MeidanInDataFlow {
    /**
     * 题目：数据流中的中位数
     *
     * 题干：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
     * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
     * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *
     * 解题思路：
     * @param num
     */
    public boolean g_InvalidInput = false;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void Insert(Integer num) {
        //将数据分成前后两个部分，前面部分所有数小于后面部分所有数，前面部分用最大堆存储，后面部分用最小堆存储
        if (((minHeap.size() + maxHeap.size())&1) == 0){//当前数据个数为偶数，将新数据插入到最小堆中
            if(!minHeap.isEmpty()){
                if(num < minHeap.peek()){
                    //新数据比后面部分的最小数要小，现将它插入到最大堆中，然后将最大堆中的最大数插入到最小堆中
                    maxHeap.offer(num);
                    int tmp = maxHeap.poll();
                    minHeap.offer(tmp);
                }else{//新数据不小于后面部分的最小数，将它直接插入到最小堆中
                    minHeap.offer(num);
                }
            }else{
                minHeap.offer(num);
            }

        }else{//当前数据个数为奇数，将新数据插入到最大堆中
            if(!maxHeap.isEmpty()){
                if(num > maxHeap.peek()){
                    //与上类似
                    minHeap.offer(num);
                    int tmp = minHeap.poll();
                    maxHeap.offer(tmp);
                }else{
                    maxHeap.offer(num);
                }
            }else{
                maxHeap.offer(num);
            }
        }
    }

    public Double GetMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0){
            g_InvalidInput = true;
            return 0.0;
        }
        int Odd = (size & 1);  //1：  奇数    0：偶数

        double median = (Odd == 0) ? ((minHeap.peek() + maxHeap.peek()) / 2.0) : minHeap.peek();

        return median;

    }
}
