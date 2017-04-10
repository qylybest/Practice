/**
 * Created by eric on 2017/4/10.
 */
public class ProducerConsumer {
    public static void main(String[] args) {

        Table table = new Table();
        Thread t1 = new Thread(new Chef(table));
        Thread t2 = new Thread(new Customer(table));

        t1.start();
        t2.start();

    }

}


class Dish {
    private final int id;

    public int getId() {
        return id;
    }

    Dish(int id){
        this.id = id;
    }

    public String toString(){
        return "Dish id : " + id;
    }
}

class Chef implements Runnable{
    private final Table table;

    Chef(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            table.put(new Dish(i));
        }
    }
}


class Customer implements Runnable {
    private final Table table;

    Customer(Table table){
        this.table = table;
    }

    @Override
    public void run(){
        for(int i = 0; i< 20; i++){
            table.get();
        }
    }
}

//消费和生产的对象, 食物类,这是我们的核心类, 同步代码在该类中体现.
//发现生产线程，消费线程里是不写同步代码的。
class Table {
    static int index = 0;
    int MAX = 10;

    Dish[] d = new Dish[10];

    public synchronized void  put(Dish dish){
        while(index >= MAX){
            try {
                System.out.println("桌上摆满了食物，不能再放了！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("上菜啦："+ dish);
        d[index++] = dish;
        notifyAll();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void get(){
        while(index <= 0){
            System.out.println("食物被吃光了，坐等吃的！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index --;
        System.out.println(index + "位置上被吃了新的美食！");
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        notifyAll();
    }
}
