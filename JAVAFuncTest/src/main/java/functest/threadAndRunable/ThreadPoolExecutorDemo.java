package functest.threadAndRunable;

import leetcode.easy.addtwonumbers.AddTwoNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池每次会同时执行 5 个任务，这 5 个任务执行完之后，剩余的 5 个任务才会被执行。
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;//核心线程数为 5。
    private static final int MAX_POOL_SIZE = 10;// 最大线程数 10
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;//等待时间为 1L。
    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,//线程池中一直有的线程个数，默认情况下即使空闲也不会被回收（可以通过设置allowCoreThreadTimeOut参数来改变默认）
                MAX_POOL_SIZE,//线程池中可以持有的最多线程数
                KEEP_ALIVE_TIME,//超过corePoolSize数的空闲线程在被销毁之前等待新任务到达的最长时间
                TimeUnit.SECONDS,// 等待时间的单位为 TimeUnit.SECONDS。
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),// 任务队列为 ArrayBlockingQueue，并且容量为 100;
                new ThreadPoolExecutor.CallerRunsPolicy());// 饱和策略为 CallerRunsPolicy。
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
        List<Integer> ansList = new ArrayList<Integer>();
        int[] ansArr =  new int[3];
        int b = ansArr.length;
        int a = 1;
        ansList.add(a);

    }


}


