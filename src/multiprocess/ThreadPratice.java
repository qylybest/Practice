package multiprocess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by eric on 2017/4/2.
 */
public class ThreadPratice {
	public static void main(String[] args) {
		Prin p = new Prin();
		new Thread(p).start();
		new Thread(p).start();
		new Thread(p).start();
//        new Prin2().start();
//        new Prin2().start();
//        new Prin2().start();
        ExecutorService pool = Executors.newFixedThreadPool(2);
    }




}

class Prin implements Runnable{
	private int i = 10;
	public void run(){
		while(i>0){
//            try{
//                Thread.sleep(200);
				System.out.println("还剩"+i--);
//            }catch(InterruptedException e){

//            }
		}
	}
}

class Prin2 extends Thread{
	private int i = 10;
	public void run(){
		while(i>0){
			try{
				Thread.sleep(200);
				System.out.println("还剩"+i--);
			}catch(InterruptedException e){

			}
		}
	}
}




