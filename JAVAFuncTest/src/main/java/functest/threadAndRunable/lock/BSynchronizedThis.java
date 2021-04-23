package functest.threadAndRunable.lock;

/**
 * 接a,可以用指定加锁对象的方法解决这个问题,
 * 这里因为两个Thread跑的是同一个Count实例,所以可以直接给this加锁:
 * @Author: jintienan
 * @Date: 2021/3/23 16:30
 */
public class BSynchronizedThis {
    public static void main(String[] args) {
        BCount bCount = new BCount();
        Thread t1 = new Thread(bCount);
        Thread t2 = new Thread(bCount);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(BCount.getCount());
    }
}

class BCount implements Runnable {
    private static int sCount = 0;

    public static int getCount() {
        return sCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this){
                sCount++;
            }
        }
    }
}