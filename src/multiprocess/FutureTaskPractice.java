package multiprocess;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by eric on 2017/4/10.
 */
public class FutureTaskPractice {
    public static void main(String[] args) {
        FutureTask<String> f = new FutureTask<String>(new MyTask());
        //产生线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //提交给线程池执行
        executorService.submit(f);
        System.out.println("线程调用完了");

        try {
            System.out.println("我正在干其他正事。。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("回过头来，看异步执行完后的结果：" + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }
}

class MyTask implements Callable {

    @Override
    public String call(){
        Long i = 0L;
        Long s = 0L;
        while(i<10){
           s += i;
           i++;
        }

        return s.toString();
    }
}
