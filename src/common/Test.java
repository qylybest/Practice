package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        Integer result = test.f(108);
        System.out.println(1<<32-1);
    }

    static int f(int n){
        if(n == 1) return 0;
        if(n == 2) return 2;
        return f(n-1) + f(n / 2 );
    }

    Map<String,String> map = new HashMap<>();


    public Integer fu(Integer cap){
        int MAX = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n<0)? 1 : (n>=MAX)? MAX:n+1;



    }


}
