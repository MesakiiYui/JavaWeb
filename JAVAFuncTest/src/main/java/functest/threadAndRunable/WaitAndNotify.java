package functest.threadAndRunable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jintienan
 * @Date: 2021/3/18 10:32
 */
public class WaitAndNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args)throws Exception{
        Thread waitThread = new Thread(new Wait(), "WaitingThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    public static String getDate(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    static class Wait implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                while(flag){
                    try{
                        System.out.println(Thread.currentThread() +"flag is true. wait @" + getDate());
                        lock.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " flag is false. running @ " + getDate());
                }

            }
        }


    }
    static class Notify implements Runnable{
        @Override
        public void run(){
            // 加锁，拥有 lock 的 Monitor
            synchronized (lock){
                // 获取 lock 的锁，然后进行通知，通知时不会释放 lock 的锁，
                // 直到当前线程释放了 lock 后， WaitThread 才能从 wait 方法中返回
                System.out.println(Thread.currentThread() + " hold lock.notify @ " + getDate());
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again. sleep @ " + getDate());
                SleepUtils.second(5);
            }
        }
    }
}
