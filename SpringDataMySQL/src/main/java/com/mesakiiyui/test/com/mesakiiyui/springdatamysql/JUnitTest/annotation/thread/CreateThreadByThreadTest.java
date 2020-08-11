package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest.annotation.thread;

import org.junit.Test;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
/**
 * 创建线程只有一种方式那就是构造Thread类，其实现方式有三种。--之一--thread
 * https://juejin.im/post/6844904199004635143
 * @Author: jintienan
 * @Date: 2020/8/3 16:34
 */
@Slf4j
public class CreateThreadByThreadTest extends  Thread {

    @SuppressWarnings("InfiniteLoopStatement")// 消除警告强迫症
    @Override
    public void run() {
        while (true) {
            // this.getName()获取当前线程的名称。
            System.out.println(this.getName() + "create Thread test success!");
        }
    }

    @SneakyThrows
    @Test
    public void testThreadCreateByThreadStart() {
        log.info("线程启动！");
        // 第一种写法通过new CreateThreadByThreadTest()来创建对象
        CreateThreadByThreadTest threadFirstTime = new CreateThreadByThreadTest();
        // 通过Thread.start()来启动线程
        threadFirstTime.start();
    }
    @Test
    public void testThreadCreateByNewThread(){
        // 第二种 通过把new ThreadFirstTime()对象当作参数传入Thread的有参构造器中
        Thread thread = new Thread(new CreateThreadByThreadTest());
        thread.start();
    }
}
