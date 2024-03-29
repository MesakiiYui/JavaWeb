package functest.threadAndRunable;

/**
 * @Author: jintienan
 * @Date: 2021/3/19 10:25
 */
public class ThreadLocalDemo2 {
    /**
     * 从这段代码的输出结果可以看出，在main线程中和thread1线程中，
     * longLocal保存的副本值和stringLocal保存的副本值都不一样。
     * 最后一次在main线程再次打印副本值是为了证明在main线程中和thread1线程中的副本值确实是不同的。
     * 　　总结一下
     * 　　1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
     * 　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，
     * 因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
     * 　　3）在进行get之前，必须先set，否则会报空指针异常；
     */
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo2 ThreadLocalDemo2 = new ThreadLocalDemo2();


        ThreadLocalDemo2.set();
        System.out.println("1***"+ThreadLocalDemo2.getLong());
        System.out.println("1***"+ThreadLocalDemo2.getString());


        Thread thread1 = new Thread(){
            public void run() {
                ThreadLocalDemo2.set();
                System.out.println("2***"+ThreadLocalDemo2.getLong());
                System.out.println("2***"+ThreadLocalDemo2.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println("3***"+ThreadLocalDemo2.getLong());
        System.out.println("3***"+ThreadLocalDemo2.getString());
    }
}
