package functest.threadAndRunable.countDownLatch;

/**
 * @Author: jintienan
 * @Date: 2021/5/14 9:12
 */
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主线程等待子线程执行完成再执行
 */
@Slf4j
public class CountdownLatchTest1 {

//    private static List<String> resList = new ArrayList<>();// 执行两次会串数据，最终OOM

    public static void main(String[] args) {
        List<String> resListMain = syncGetData(3);
        log.info("resListMain"+JSON.toJSONString(resListMain));
        List<String> resListMain2 = syncGetData(4);
        log.info("resListMain"+JSON.toJSONString(resListMain2));
    }

    private static List<String> syncGetData(int nThread){
        ExecutorService service = Executors.newFixedThreadPool(nThread);
        List<String> resList = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(nThread);
        for (int i = 0; i < nThread; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        resList.add(Thread.currentThread().getName());
                        Thread.sleep((long) (Math.random() * 2000));
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                        latch.countDown();//当前线程调用此方法，则计数减一
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            latch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
            log.info("resList"+ JSON.toJSONString(resList));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }

        return resList;
    }
}
