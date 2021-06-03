package functest.threadAndRunable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: jintienan
 * @Date: 2021/2/25 15:27
 * 原子操作类AtomicInteger详解
 * https://blog.csdn.net/fanrenxiang/article/details/80623884
 *
 *
 */
public class AtomicIntegerTest implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static int commonInteger = 0;

    /**
     * 线程安全
     */
    private void addAtomicInteger() {
        atomicInteger.getAndIncrement();
    }

    /**
     * 线程不安全
     */
    private void addCommonInteger() {
        commonInteger++;
    }

    @Override
    public void run() {
        //可以调大10000看效果更明显
        for (int i = 0; i < 10000; i++) {
            addAtomicInteger();
            addCommonInteger();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        Thread thread1 = new Thread(atomicIntegerTest);
        Thread thread2 = new Thread(atomicIntegerTest);
        thread1.start();
        thread2.start();
        //join()方法是为了让main主线程等待thread1、thread2两个子线程执行完毕
        thread1.join();
        thread2.join();
        System.out.println("AtomicInteger add result = " + atomicInteger.get());// 线程安全
        System.out.println("CommonInteger add result = " + commonInteger);// 线程不安全
    }


}
