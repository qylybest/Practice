package common;

import java.util.Random;

/**
 * Created by eric on 2017/4/20.
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random1 = new Random();
        Random random2 = new Random();

        System.out.println("random1.nextInt(): " + random1.nextInt()
                + "; random2.nextInt(): " + random2.nextInt());
        System.out.println("===============================");
        System.out.println("random1.nextDouble(): " + random1.nextDouble()
                + "; random2.nextDouble(): " + random2.nextDouble());
        System.out.println("===============================");
        System.out.println("random1.nextFloat(): " + random1.nextFloat()
                + "; random2.nextFloat(): " + random2.nextFloat());
        System.out.println("===============================");

        System.out.println(random1.nextInt(10)); // 0~10 均匀 包括0，10
        System.out.println(random1.nextFloat()); // 0~1 均匀 包括0，1
    }
}
