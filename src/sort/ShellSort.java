package sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {3,5,1,9,0,2,7,4,6,8};

        shellSort(a);

        SortUtil.dis(a);
    }

    static void shellSort(int[] a){
        if(null == a || a.length <= 1) return;

        int len = a.length;

        //希尔排序的步长
        int step = len;

        while(step > 0){
            // 0~step-1是每个分数组的头，对每个分数组进行直接插入排序
            for(int i = step; i <= len-1; i++){
                int j = i;
                while(j >= step && a[j] < a[j-step] ){
                    SortUtil.swap(a,j,j-step);
                    j -= step;
                }
            }

            step /= 2;
        }
    }


}
