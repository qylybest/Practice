package sort;

/*
   冒泡排序 O(N^2)
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] a = {3,5,1,9,0,2,7,4,6,8};

        bubbleSort(a);

        SortUtil.dis(a);


    }

    static void bubbleSort(int[] a){
        if(null == a || a.length <=1 ) return;

        int l = a.length;

        for(int i = 0; i <= l-2 ; i++){
            for(int j = l-1; j > i ; j--){
                if(a[j] < a[j-1]){
                    SortUtil.swap(a,j,j-1);
                }
            }
        }
    }


}
