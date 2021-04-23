package functest.threadAndRunable.lock;

/**
 * 接C,这次给自增方法加锁
 * synchronized直接作用于静态方法的用法和C给实例方法加锁类似,不过它是作用于静态方法:
 * @Author: jintienan
 * @Date: 2021/3/23 16:38
 */
public class DSynchronizedIncrease {
    public static void main(String[] args) {
        DCount dCount = new DCount();
        Thread t1 = new Thread(dCount);
        Thread t2 = new Thread(dCount);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(DCount.getCount());
    }
}
class DCount implements Runnable{
    private static int sCount = 0;
    public static int getCount() {
        return sCount;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            increase();
        }
    }
    private static synchronized void increase() {
        sCount++;
    }
}
