package offer66;

public class MergeSort {

    public void mergeSort(int [] data){
        if (data == null ||data.length == 0)
            return;
        int start = 0;
        int end = data.length - 1;
        mergeSortCore(data, start, end);
    }

    public void mergeSortCore(int [] data, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSortCore(data, start, mid);
            mergeSortCore(data, mid+1, end);
            merge(data, start, mid, end);
        }
    }

      public void merge(int [] data, int start, int mid, int end){
          int[]tmp = new int[data.length];
          int p1 = start;
          int p2 = mid + 1;
          int k = start;
          while(p1 <= mid && p2 <= end){
              if(data[p1] <= data[p2]){
                  tmp[k++] = data[p1++];
              }else{
                  tmp[k++] = data[p2++];
              }
          }
          while(p1 <= mid){
              tmp[k++] = data[p1++];
          }

          while(p2 <= end){
              tmp[k++] = data[p2++];
          }

          for (int i = start; i <= end; i++) {
              data[i] = tmp[i];
          }
      }

}
