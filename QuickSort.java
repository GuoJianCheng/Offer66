package offer66;

public class QuickSort {
    public void quickSort(int [] data){
        if(data==null || data.length == 0)
            return ;
        quickSortCore(data,0,data.length-1);
    }
    public void quickSortCore(int [] data, int start, int end){
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
            quickSortCore(data,start, i-1);
            quickSortCore(data, i+1,end);
        }
    }
}
