package functest.threadAndRunable;

/**
 * @Author: jintienan
 * @Date: 2020/11/9 9:19
 * 双重校验锁方式实现
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton(){
    }

    public synchronized static Singleton getUniqueInstance() {
        // 先判断兑现是否已经实例化过，没有实例化才进入加锁代码
        if(uniqueInstance == null) {
            synchronized (Singleton.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
