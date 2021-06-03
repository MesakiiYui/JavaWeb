package functest.threadAndRunable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 示例在
 * 执 行 过 程中， main线 程通 过 中断操作和 cancel()方法均可使 CountThread得以
 * 终 止。 这 种通 过标识 位或者中断操作的方式能 够 使 线 程在 终 止 时 有机会去清理 资 源，而
 * 不是武断地将 线 程停止，因此 这 种 终 止 线 程的做法 显 得更加安全和 优 雅。
 * @Author: jintienan
 * @Date: 2021/3/22 9:55
 */
@Slf4j
public class SafeInterrupt {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠 1 秒， main 线程对 CountThread 进行中断，使 CountThread 能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        // 睡眠 1 秒， main 线程对 Runner two 进行取消，使 CountThread 能够感知 on 为 false 而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancle();

    }

    public static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run(){
            while(on && !Thread.currentThread().isInterrupted()){
                i ++;
            }
            log.info("Count i =" + i);
        }
        public void cancle(){
            on = false;
        }
    }
}
