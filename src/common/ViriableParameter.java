package common;

/**
 * Created by eric on 2017/4/26.
 */
public class ViriableParameter {

    public static void main(String[] args) {
        System.out.println("sumNum(1,2,3,4,5): " + sumNum(1,2,3,4,5));
        System.out.println("sumNum(): " + sumNum());
        System.out.println("sumNum2(): " + sumNum2(new int[0]));
        System.out.println("sumNum3(\"I am eric\",1,2,3,4,5) : " + sumNum3("I am eric",1,2,3,4,5));
    }

    public static int sumNum(int... numbers){
        int sum = 0;
        for(int i:numbers){
            sum += i;
        }
        return sum;
    }

    public static int sumNum2(int[] numbers){
        int sum = 0;
        for(int i:numbers){
            sum += i;
        }
        return sum;
    }

    public static int sumNum3(String s,int... numbers){
        System.out.println(s);
        int sum = 0;
        for(int i:numbers){
            sum += i;
        }
        return sum;
    }
}
