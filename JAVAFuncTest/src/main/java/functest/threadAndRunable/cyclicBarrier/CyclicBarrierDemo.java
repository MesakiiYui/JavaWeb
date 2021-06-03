package functest.threadAndRunable.cyclicBarrier;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: jintienan
 * @Date: 2021/5/14 16:44
 */
public class CyclicBarrierDemo {

    @Test
    public void test() {
        // CyclicBarrier(int parties, Runnable barrierAction)
        // 创建一个CyclicBarrier实例，parties指定参与相互等待的线程数，barrierAction指定当所有线程到达屏障点之后，
        // 首先执行的操作，该操作由最后一个进入屏障点的线程执行。
        final CyclicBarrier barrier = new CyclicBarrier(2, myThread);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    barrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    barrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "thread2").start();
    }

    Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("myThread");
        }
    }, "thread3");
}
