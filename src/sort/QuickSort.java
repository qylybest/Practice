package sort;

/*
    快速排序 O(NlogN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3,5,1,9,0,2,7,4,6,8};

        quickSort(a,0,a.length-1);

        SortUtil.dis(a);
    }

    static void quickSort(int[] a,int left,int right){
        if(null == a || a.length <=1 || left >= right) return;

        int standard = a[left];

        int begin = left;
        int end = right;

        while(left < right){

            while(left < right && a[right] > standard){
                right -- ;
            }
            a[left] = a[right];

            while(left < right && a[left] < standard){
                left ++ ;
            }
            a[right] = a[left];

        }
        a[left] = standard;

        quickSort(a,begin,left-1);
        quickSort(a,left+1,end);
    }


}
