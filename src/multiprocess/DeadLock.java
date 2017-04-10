package multiprocess;

/**
 * Created by yaosu on 2017/4/9 0009.
 */
public class DeadLock implements Runnable{
	static Object o1 = new Object();
	static Object o2 = new Object();

    boolean flag = true;

    DeadLock(Boolean flg){
        this.flag = flg;
    }

	public void run(){
		if(flag){
			synchronized (o1){
				try {
					Thread.sleep(1000);
					synchronized (o2){
						System.out.println("获取到了o1和o2两个对象锁");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			synchronized (o2){
				try {
					Thread.sleep(1000);
					synchronized (o1){
						System.out.println("获取到了o2和o1两个对象锁");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));

        t1.start();
        t2.start();
    }
}
