///**
// * Created by eric on 2017/4/10.
// */
//public class ProducerConsumer {
//
//}
//
//
//class Dish {
//    private String id;
//
//    public String getId() {
//        return id;
//    }
//
//    Dish(String id){
//        this.id = id;
//    }
//
//    public String toString(){
//        return "Dish id : " + id;
//    }
//}
//
//class Chef implements Runnable{
//    Table table;
//
//    Chef(Table table){
//        this.table = table;
//    }
//
//    public synchronized static void make(){
//        while(Table.index >= 10){
//            this.wait();
//        }
//        notifyAll();
//    }
//
//    public void run(){
//
//    }
//}
//
//class Consumer implements Runnable {
//    public synchronized  static Dish eat (){
//
//    }
//
//    public void run(){
//
//    }
//}
//
//class Table {
//    static int index = 0;
//    Dish[] d = new Dish[10];
//}
