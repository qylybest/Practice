package sort;


/*
    插入排序 O(N^2)
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {3,5,1,9,0,2,7,4,6,8};

        insertSort(a);

        SortUtil.dis(a);
    }

    static void insertSort(int[] a){
        if(null == a || a.length <=1 ) return;

        int l = a.length;

        for(int i = 1; i <= l-1; i++){
            int j = i;
            while(j >= 1 && a[j] < a[j-1] ){
                SortUtil.swap(a,j,j-1);
                j--;
            }
        }
    }

}
