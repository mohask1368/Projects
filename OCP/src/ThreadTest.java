public class ThreadTest extends Thread{

Object object ;
@Override
public void run(){

    System.out.println("scan");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    synchronized (object){

        System.out.println("other jobs");
        object.notify();
    }
}
}
