package functest.threadAndRunable;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @Author: jintienan
 * @Date: 2020/11/11 10:43
 */
public class ThreadLocalDemo {
    public static class MyRunnable implements Runnable {

        // 示例1，创建了一个MyRunnable实例，并将该实例作为参数传递给两个线程。两个线程分别执行run()方法，
        // 并且都在ThreadLocal实例上保存了不同的值。
        // 如果它们访问的不是ThreadLocal对象并且调用的set()方法被同步了，则第二个线程会覆盖掉第一个线程设置的值。
        // 但是，由于它们访问的是一个ThreadLocal对象，因此这两个线程都无法看到对方保存的值。也就是说，它们存取的是两个不同的值。
        private ThreadLocal threadLocal = new ThreadLocal();
        @Override
        public void run() {
            System.out.println("Thread Name = " + Thread.currentThread().getName()+"default Formatter = "+formatter.get().toPattern());
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            formatter.set(new SimpleDateFormat());
            System.out.println("Thread Name = " + Thread.currentThread().getName()+"default Formatter = "+formatter.get().toPattern());
            System.out.println("threadLocal.get()"+threadLocal.get());
        }

        //示例2 SimpleDateFormat 不是线程安全的，所以每个线程都要有自己的独立的副本
        private static final ThreadLocal<SimpleDateFormat> formatter =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm:ss"));





        public static void main(String[] args) {
            MyRunnable sharedRunnableInstance = new MyRunnable();
            Thread thread1 = new Thread(sharedRunnableInstance);
            Thread thread2 = new Thread(sharedRunnableInstance);
            thread1.start();
            thread2.start();

            for(int i=0;i<10;i++){
                Thread t = new Thread(sharedRunnableInstance, ""+i);
                try {
                    Thread.sleep(new Random().nextInt(1000));
                }catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
                t.start();
            }
        }
    }



}
