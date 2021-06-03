package functest.threadAndRunable.lock;

/**
 * 线程不安全，自增出错
 * 得到的结果并不是20000,而是一个比20000小的数,如14233。
 * 这是为什么呢？假设两个线程分别读取sCount为0,然后各自技术得到sCount为1,
 * 并先后写入这个结果,因此,虽然sCount++执行了2次,但是实际sCount的值只增加了1。
 * @Author: jintienan
 * @Date: 2021/3/23 16:26
 */
public class AThreadConflict {
    public static void main(String[] args) {
        ACount aCount = new ACount();
        Thread t1 = new Thread(aCount);
        Thread t2 = new Thread(aCount);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ACount.getCount());
    }
}

class ACount implements Runnable {
    private static int sCount = 0;

    public static int getCount() {
        return sCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            sCount++;
        }
    }
}
