package multiprocess;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by eric on 2017/4/26.
 */
public class AbilitilyTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i<10000000; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread());
                    for(int j = 0; j<1000; j++){
                        int k = new Random().nextInt(10000);
                        if(k == 9527){
                            System.out.println("bingo!!!!!!!!");
                            break;
                        }
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
