package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest.annotation.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程只有一种方式那就是构造Thread类，其实现方式有三种。--之三-future
 * @Author: jintienan
 * @Date: 2020/8/5 10:22
 */
public class CreateThreadByFutureTaskTest implements Callable<String> {
    // 创建任务类，通过实现Callable<String>接口，重写call()方法来实现一个任务类，此处可以类比Runnable接口。
    // 但是两者不同的是Runnable接口实现的是run()方法是一个void的方法，但是Callable<String>实现的是call()可以看到给的例子里面返回参数是String，是一个有返回值的方法。
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "create FutureTask success!";
    }

    @Test
    public void testFutureTask(){
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CreateThreadByFutureTaskTest());
        // 创建线程，调用Thread.start()启动线程
        new Thread(futureTask).start();
        // 获取线程返回结果
        try{
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }


}
