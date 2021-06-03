package functest.threadAndRunable;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: jintienan
 * @Date: 2021/5/12 13:52
 * https://zhuanlan.zhihu.com/p/60986630
 */
public class ThreadPoolElegantCreate {

    //同样，Executors提供的工厂方法中，我们也可以通过传入一个 ThreadFactory 来自定义线程创建时的一些属性,使用lambda可替换为
    private static ExecutorService newCachedExec = Executors.newCachedThreadPool(r -> {
        Thread t = new Thread(r);
        t.setName("worker-thread-" + UUID.randomUUID().toString());
        return t;
        //以上代码可以看出，通过Executors提供的工厂方法，我们可以很简单的创建一个线程池来使用。
        // 通过 ExecutorService 提供的 submit(Runnable) 接口，即可简单的向线程池提交任务。
        // CachedThreadPool 与 FixedThreadPool

        //作为最常用的两种线程池，CachedThreadPool 和 FixedThreadPool 在不同场景，有着不同的应用。
        // - CachedThreadPool 主要被应用在响应时间要求高、数据量可控的场景，由于其不限制创建线程的个数，故若数据量不可控，会造成程序 OOM
        // - FixedThreadPool 主要被应用在线程资源有限，数据量较小或不可控场景，由于其线程数量有限，针对于过多的数据量，默认将会进行丢弃，
        // 但是不会造成程序 OOM 我们可以通过自己的实际场景需求，选择不同的线程池。
    });



    private static ExecutorService exec = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), r -> {
        Thread t = new Thread(r);
        t.setName("worker-thread-" + UUID.randomUUID().toString());
        return t;
    }, (r, executor) -> {
        if (!executor.isShutdown()) {
            try {
                //阻塞等待put操作
                System.err.println("waiting queue is full, putting...");
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static AtomicInteger at = new AtomicInteger(0);

    public static void main(String[] args) {
        while (true) {
            exec.submit(() -> {
                System.err.println("Worker" + at.getAndIncrement() + " start.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("Worker end.");
            });
        }
    }




    private static void createThreadPool(){

    }
}
