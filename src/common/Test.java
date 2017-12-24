package common;

/**
 * Created by eric on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();


        Integer result = test.fu(3);
        System.out.println(result);
    }

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
