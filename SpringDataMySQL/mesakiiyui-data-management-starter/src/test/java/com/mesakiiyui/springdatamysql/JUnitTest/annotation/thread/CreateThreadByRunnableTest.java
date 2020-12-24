package com.mesakiiyui.springdatamysql.JUnitTest.annotation.thread;

import org.junit.Test;

/**
 * 创建线程只有一种方式那就是构造Thread类，其实现方式有三种。--之二-runnable
 * @Author: jintienan
 * @Date: 2020/8/5 10:09
 */
public class CreateThreadByRunnableTest implements Runnable{

    @SuppressWarnings("InfiniteLoopStatement")// 消除警告强迫症
    @Override
    public void run() {
        while (true) {
            // Thread.currentThread()来获取当前的线程对象。
            System.out.println(Thread.currentThread().getName() + "create Thread test success!");
        }
    }

    @Test
    public void testThreadCreateByRunnable(){
        // 第三种方式
        // 通过实现Runnable接口并实现run()方法来实现线程
        // 创建一个Thread线程，CreateThreadByThreadTest
        Thread thread3 = new Thread(new CreateThreadByThreadTest());
        // 调用 Thread.start()方式启动线程
        thread3.start();
    }


}
