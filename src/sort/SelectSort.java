package sort;

/**
 *  选择排序 O(N^2)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {3,5,1,9,0,2,7,4,6,8};

        selectSort(a);

        SortUtil.dis(a);

    }

    static void selectSort(int[] a){
        if(null == a || a.length <= 1) return;

        int len = a.length;

        for(int i=0; i < len; i++){
            int min = a[i];
            int index = i;
            for(int j = i+1; j < len; j++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            SortUtil.swap(a,i,index);
        }

    }
}
