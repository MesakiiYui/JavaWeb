package functest.threadAndRunable.lock;

/**
 * 接B，这次给run方法加锁
 * @Author: jintienan
 * @Date: 2021/3/23 16:38
 */
public class CSynchronizedRun {
    public static void main(String[] args) {
        CCount cCount = new CCount();
        Thread t1 = new Thread(cCount);
        Thread t2 = new Thread(cCount);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(CCount.getCount());
    }
}
class CCount implements Runnable{
    private static int sCount = 0;
    public static int getCount() {
        return sCount;
    }
    @Override
    public synchronized void run(){
        for (int i = 0; i < 10000; i++) {
            sCount++;
        }
    }
}
