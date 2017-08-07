package multiprocess;

/**
 * Created by eric on 2017/4/12.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程之间共享数据
 *
 一.目标

 谈到多线程共享数据，理想情况下我们希望做到“同步”和“互斥”。这是目标我们暂且把它先放到这。

 二.分类

 多线程共享数据通常的场景有一下两种：

 场景一：

 卖票，我们都买过火车票。要买火车票我们可以去车站，也可以通过代售点（或网购），但不管有多少种方式火车票的总数是一定的。

 场景抽象：

 对于卖票系统每个线程的核心执行的  ###"代码都相同"###   （就是票数–）。

 解决方法：

 只需创建一个Runnable,这个Runnable里有那个共享数据。

 场景二：比较常见的例子，银行问题，我们对账户可以存钱也可以取钱，怎么保证这样的数据共享呢？

 场景抽象：

 ###"每个线程执行的代码不同"###（比如上面的问题，对每个账户可以执行++操作和–操作），这时候需要用不同的Runnable对象，有如下两种方式来实现这些Runnable之间的数据共享

 解决方案：
 有两种方法来解决此类问题：
 将共享数据封装成另外一个对象中封装成另外一个对象中，然后将这个对象逐一传递给各个Runnable对象，每个线程对共享数据的操作方法也分配到那个对象身上完成，这样容易实现针对数据进行各个操作的互斥和通信
 将Runnable对象作为偶一个类的内部类，共享数据作为这个类的成员变量，每个线程对共享数据的操作方法也封装在外部类，以便实现对数据的各个操作的同步和互斥，作为内部类的各个Runnable对象调用外部类的这些方法。
 */

/**
 * 其实我觉得用static关键字，就可以共享了啊。。。
 */
public class ShareDataAmongMulityProcess {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new TicketWindow1("窗口1"));
        executorService.submit(new TicketWindow1("窗口2"));
        executorService.submit(new TicketWindow1("窗口3"));
        executorService.submit(new TicketWindow1("窗口4"));
        executorService.submit(new TicketWindow1("窗口5"));

        executorService.shutdown();
    }
}


class TicketWindow1 implements Runnable {

    private static int totalTicket = 100;
    private String name;

    TicketWindow1(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(totalTicket > 0) {
            System.out.println(name + " 卖出了 " + totalTicket--);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


