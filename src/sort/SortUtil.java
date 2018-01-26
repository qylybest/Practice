package sort;

public class SortUtil {

    static void swap(int[] a,int index1, int index2){
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static void dis(int[] a){
        if(null == a || a.length <=1 ) return;

        int l = a.length;

        System.out.println("=================================");
        for(int i = 0; i <= l-1 ; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
        System.out.println("==================================");
    }
}
