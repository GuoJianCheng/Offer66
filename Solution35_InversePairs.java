package offer66;

public class Solution35_InversePairs {
    /**
     * 题目：数组中的逆序对
     * 题干：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 解题思路：在归并排序的过程中计算逆序对
     * @param array
     * @return
     */

    public int count = 0;

    public int InversePairs(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int start = 0;
        int end = array.length - 1;
        mergeSort(array, start, end);
        return count % 1000000007;
    }

    public void mergeSort(int [] data, int start, int end){
        if(start < end){
            int mid = (start + end)>>1;
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            merge(data, start, mid, end);
        }
    }

    public void merge(int [] data, int start, int mid, int end){
//        int [] tmp = new int[data.length]; 不考虑时间的话，这样也可以
        int [] tmp = new int[end-start+1];//当考虑时间的话，必须这样，否则超时!!!
        int p1 = mid;
        int p2 = end;
        int k = tmp.length - 1;
        while(p1>=start && p2>=mid+1){
            if(data[p1] > data[p2]){
                tmp[k--] = data[p1--];
                count += p2 - mid;
                count %= 1000000007;
            }else{
                tmp[k--] = data[p2--];
            }
        }
        while(p1>=start){
            tmp[k--] = data[p1--];
        }
        while(p2>=mid+1){
            tmp[k--] = data[p2--];
        }
        for (int i = 0; i < tmp.length ; i++) {
            data[start+i] = tmp[i];//注意调整下标data[start+i]
        }
    }
}
